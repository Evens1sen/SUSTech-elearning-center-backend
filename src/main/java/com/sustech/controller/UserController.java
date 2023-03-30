package com.sustech.controller;


import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.dto.Result;
import com.sustech.dto.ResultCode;
import com.sustech.dto.UserLoginParam;
import com.sustech.dto.UserRegisterParam;
import com.sustech.entity.User;
import com.sustech.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Api(tags = "UserController")
@RestController
@RequestMapping("//user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Demo")
    @GetMapping("/demo")
    public String demo() {
        return "qx";
    }

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public Result<String> register(@Valid @RequestBody UserRegisterParam userRegisterParam) {
        User user = new User();
        user.setUserId(userRegisterParam.getUserId());

        String saltHash = SaSecureUtil.md5(userRegisterParam.getPassword() + user.getUserId() + "qx");
        user.setPassword(saltHash);

        user.setName(userRegisterParam.getName());
        user.setEmail(userRegisterParam.getEmail());

        boolean result;
        try {
            result = userService.save(user);
        } catch (Exception e) {
            return new Result<>(ResultCode.FAILED, "SID或昵称已存在");
        }

        if (result) {
            return new Result<>(ResultCode.SUCCESS, "注册成功");
        }
        return new Result<>(ResultCode.FAILED, "注册失败");
    }

    @ApiOperation(value = "发送验证码")
    @PostMapping("/verifyEmail/{email}")
    public String verifyEmail(@PathVariable String email) {
        return userService.sendVerification(email);
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public SaResult login(@Valid @RequestBody UserLoginParam userLoginParam) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userLoginParam.getUid());
        User user = userService.getOne(wrapper);
        if (user == null) {
            return SaResult.error("请先注册");
        }
        if (StpUtil.isDisable(user.getUserId())) {
            return SaResult.error("帐号被封");
        }
        if (!Objects.equals(user.getPassword(),
                SaSecureUtil.md5(userLoginParam.getPassword() + user.getUserId() + "qx"))) {
            return SaResult.error("密码错误");
        }

        StpUtil.login(user.getUserId());
        return SaResult.ok("登录成功");
    }

    @ApiOperation(value = "检测是否登录")
    @GetMapping("/isLogin")
    public boolean isLogin() {
        return StpUtil.isLogin();
    }

    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    public String logout() {
        StpUtil.logout();
        return "登出成功";
    }

}


package com.sustech.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.sustech.dto.UserLoginParam;
import com.sustech.dto.UserRegisterParam;
import com.sustech.entity.User;
import com.sustech.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class UserControllerTest {

    @Autowired
    public UserController userController;

    @Autowired
    public UserService userService;

    public UserRegisterParam existingIdParam = new UserRegisterParam(114514,"null","woaidongxuelian","11912920@mail.sustech.edu.cn");

    public UserRegisterParam existingNameParam = new UserRegisterParam(1919810,"existing","woaidongxuelian","11912920@mail.sustech.edu.cn");

    public UserRegisterParam nullParam = new UserRegisterParam(1919810,"null","woaidongxuelian","11912920@mail.sustech.edu.cn");

    public UserLoginParam registeredParam = new UserLoginParam(114514,"woaidongxuelian");

    public UserLoginParam notRegisteredParam = new UserLoginParam(1919810,"woaidongxuelian");

    public UserLoginParam falsePwdParam = new UserLoginParam(114514,"woaiyongchutafei");

    @Test
    void register() {
        System.out.println(existingIdParam);
        System.out.println(existingNameParam);
        System.out.println(nullParam);
    }

    @Test
    void login() {
        System.out.println(userController.login(registeredParam));
        System.out.println(userController.login(notRegisteredParam));
        System.out.println(userController.login(falsePwdParam));
    }

    @Test
    void listUser() {
        List<User> userList = userController.listUser();
        System.out.println(userList.size());
    }

    @Test
    void listUserCourse() {
        UserLoginParam userLoginParam = new UserLoginParam();
        userLoginParam.setUid(11451414);
        userLoginParam.setPassword("11451414");
        userController.login(userLoginParam);
        System.out.println(userController.isLogin());
        System.out.println(userService.getById(11451414).getUserId());
    }

    @Test
    void isLogin() {
        System.out.println(userController.isLogin());
    }

    @Test
    void logout() {
        System.out.println(userController.logout());
    }
}
package com.sustech.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.sustech.dto.UserLoginParam;
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

    @Test
    void register() {
    }

    @Test
    void login() {
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
    }

    @Test
    void logout() {
    }
}
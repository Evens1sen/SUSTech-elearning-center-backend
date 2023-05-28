package com.sustech.controller;

import com.sustech.dto.UserLoginParam;
import com.sustech.dto.UserRegisterParam;
import com.sustech.entity.User;
import com.sustech.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserControllerTest {

    @Autowired
    public UserController userController;

    @Autowired
    public UserService userService;

    public UserRegisterParam normalParam = new UserRegisterParam(11912918, "dsh", "sepiold", "11912918@mail.sustech.edu.cn");

    public UserRegisterParam existingIdParam = new UserRegisterParam(11451414, "null", "woaidongxuelian", "11912920@mail.sustech.edu.cn");

    public UserLoginParam registeredParam = new UserLoginParam(11912918, "sepiold");

    public UserLoginParam notRegisteredParam = new UserLoginParam(1919810, "woaidongxuelian");

    public UserLoginParam falsePwdParam = new UserLoginParam(11451414, "woaiyongchutafei");

    @Test
    void register() {
        System.out.println(userController.register(normalParam));
        System.out.println(userController.register(existingIdParam));
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
        userLoginParam.setPassword("string");
        userController.login(userLoginParam);
        System.out.println(userController.isLogin());
        System.out.println(userController.listUserCourse("11451414"));
    }

    @Test
    void isLogin() {
        userController.login(registeredParam);
        System.out.println(userController.isLogin());
    }

    @Test
    void logout() {
        userController.login(registeredParam);
        System.out.println(userController.logout());
    }
}
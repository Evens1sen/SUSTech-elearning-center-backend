package com.sustech.controller;

import com.sustech.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserControllerTest {

    @Autowired
    public UserController userController;

    @Test
    void testListUser(){
        List<User> userList = userController.listUser();
        System.out.println(userList.size());
    }

}
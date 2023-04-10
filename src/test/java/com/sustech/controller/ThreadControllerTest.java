package com.sustech.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThreadControllerTest {
    @Autowired
    public ThreadController threadController;

    Integer existingUserID = 12011317;
    Integer invalidUserID = -1;

    @Test
    void testlistThreadsByUserID(){
        System.out.println(threadController.listThreadsByUserID(existingUserID));
    }

    @Test
    void testlistThreadsByInvalidUserID(){
        System.out.println(threadController.listThreadsByUserID(invalidUserID));
    }
}

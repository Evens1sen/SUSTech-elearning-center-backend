package com.sustech.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostControllerTest {
    @Autowired
    public PostController postController;

    Integer existingThreadId = 12011317;
    Integer nullThreadId = -1;

    @Test
    void getAllPostByThreadID(){
        System.out.println(postController.listPostByThread(existingThreadId));
    }

    @Test
    void testNullThreadID(){
        System.out.println(postController.listPostByThread(nullThreadId));
    }
}

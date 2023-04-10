package com.sustech.controller;

import com.sustech.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseControllerTest {

    @Autowired
    public CourseController courseController;

    @Autowired
    public CourseService courseService;

}

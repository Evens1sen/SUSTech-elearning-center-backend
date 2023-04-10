package com.sustech.controller;

import com.sustech.service.CourseEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseEventControllerTest {

    @Autowired
    public CourseEventController courseEventController;

    @Autowired
    public CourseEventService courseEventService;
}

package com.sustech.controller;

import com.sustech.service.CourseEventService;
import com.sustech.service.CourseService;
import com.sustech.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseEventControllerTest {

    @Autowired
    public CourseEventController courseEventController;

    @Autowired
    public CourseEventService courseEventService;

    @Autowired
    public CourseService courseService;

    @Autowired
    public UserService userService;


    Integer existingUserId = 114514;
    Integer nullUserId = -1;
    Integer existingCourseId = 114514;
    Integer nullCourseId = -1;
    String existingEventType = "Exam";
    String nullEventType= "Homo";

    @Test
    void getAllCourseEvent(){
        System.out.println(courseEventController.getAllCourseEvents(existingUserId));
        System.out.println(courseEventController.getAllCourseEvents(nullUserId));
    }


    @Test
    void listCourseEvent(){
        System.out.println(courseEventController.listCourseEvent(existingCourseId));
        System.out.println(courseEventController.listCourseEvent(nullCourseId));
    }

    @Test
    void listCourseEventByType(){
        System.out.println(courseEventController.listCourseEventByType(existingCourseId,existingEventType));
        System.out.println(courseEventController.listCourseEventByType(nullCourseId,existingEventType));
        System.out.println(courseEventController.listCourseEventByType(existingCourseId,nullEventType));
        System.out.println(courseEventController.listCourseEventByType(nullCourseId,nullEventType));
    }
}

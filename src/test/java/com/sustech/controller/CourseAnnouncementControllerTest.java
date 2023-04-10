package com.sustech.controller;

import com.sustech.service.CourseAnnouncementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseAnnouncementControllerTest {

    @Autowired
    public CourseAnnouncementController courseAnnouncementController;

    @Autowired
    public CourseAnnouncementService courseAnnouncementService;

    Integer exampleCourseId;
    Integer nullCourseId;

    @Test
    void listCourseAnnouncement() {
        System.out.println(courseAnnouncementController.listCourseAnnouncement(exampleCourseId));
    }

    @Test
    void testNullCourseId() {
        System.out.println(courseAnnouncementController.listCourseAnnouncement(nullCourseId));
    }

}

package com.sustech.controller;

import com.sustech.entity.Course;
import com.sustech.service.CourseService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseControllerTest {

    @Autowired
    public CourseController courseController;

    @Autowired
    public CourseService courseService;

    @Test
    void listCourse() {
        courseController.listCourse().forEach(System.out::println);
    }

    @Test
    @Order(1)
    void addCourse() {
        Course addCourse = new Course();
        addCourse.setCourseCode("CS203");
        addCourse.setCourseName("dsaa");
        addCourse.setInstructor("tb");
        addCourse.setSemester("23Spring");
        System.out.println(courseController.addCourse(addCourse));
    }

    @Test
    @Order(2)
    void updateCourse() {
        Course updateCourse = new Course();
        updateCourse.setCourseCode("CS203");
        updateCourse.setCourseName("dsaa");
        updateCourse.setInstructor("tbtb");
        updateCourse.setSemester("23Spring");
        int addedCourseId = courseController.listCourse().stream().
                filter(course -> course.getCourseCode().equals("CS203") && course.getSemester().equals("23Spring"))
                .map(Course::getCourseId).toList().get(0);
        courseController.updateCourse(addedCourseId, updateCourse);
    }

    @Test
    @Order(3)
    void deleteCourse() {
        int addedCourseId = courseController.listCourse().stream().
                filter(course -> course.getCourseCode().equals("CS203") && course.getSemester().equals("23Spring"))
                .map(Course::getCourseId).toList().get(0);
        courseController.deleteCourse(addedCourseId);
    }
}

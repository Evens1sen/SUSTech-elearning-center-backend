package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.VO.CourseEventVO;
import com.sustech.entity.Course;
import com.sustech.entity.CourseAnnouncement;
import com.sustech.entity.CourseEvent;
import com.sustech.entity.User;
import com.sustech.service.CourseAnnouncementService;
import com.sustech.service.CourseService;
import com.sustech.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Api(tags = "CourseController")
@RestController
@RequestMapping("//course")
public class CourseController {
    @Autowired
    public CourseService courseService;
    @Autowired
    public UserService userService;

    @ApiOperation(value = "获取所有课程")
    @GetMapping("/listCourse")
    public List<Course> listCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        return courseService.list(queryWrapper);
    }

    @ApiOperation(value = "增加新课程")
    @RequestMapping(value = "/addCourse/{courseId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean addCourse(@PathVariable int courseId ,String courseCode, String semester, String instructor, String courseName,String description) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseCode(courseCode);
        course.setSemester(semester);
        course.setInstructor(instructor);
        course.setCourseName(courseName);
        course.setDescription(description);
        return courseService.save(course);
    }

    @ApiOperation(value = "更新课程")
    @RequestMapping(value = "/updateCourse/{courseId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCourse (@PathVariable int courseId ,String courseCode, String semester, String instructor, String courseName,String description) {
        courseService.updateCourse(courseId, courseCode, semester, instructor, courseName, description);
    }

    @ApiOperation(value = "删除课程")
    @RequestMapping(value = "/deleteCourse/{courseId}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteCourse (@PathVariable int courseId) {
        return courseService.removeById(courseId);
    }
}


package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.entity.Course;
import com.sustech.service.CourseService;
import com.sustech.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/addCourse")
    public boolean addCourse(@RequestBody Course course) {
        course.setCourseId(null);
        return courseService.save(course);
    }

    @ApiOperation(value = "更新课程")
    @RequestMapping(value = "/updateCourse/{courseId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        course.setCourseId(courseId);
        courseService.updateById(course);
    }

    @ApiOperation(value = "删除课程")
    @RequestMapping(value = "/deleteCourse/{courseId}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteCourse(@PathVariable int courseId) {
        return courseService.removeById(courseId);
    }
}


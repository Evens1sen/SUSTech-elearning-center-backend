package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.entity.CourseEvent;
import com.sustech.service.CourseEventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Api(tags = "CourseEventController")
@RestController
@RequestMapping("//courseEvent")
public class CourseEventController {

    @Autowired
    public CourseEventService courseEventService;

    @ApiOperation(value = "获取所有课程event")
    @GetMapping("/listCourseEvent/{courseID}")
    public List<CourseEvent> listCourseEvent(@PathVariable Integer courseID) {
        QueryWrapper<CourseEvent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseID);
        return courseEventService.list(queryWrapper);
    }

}


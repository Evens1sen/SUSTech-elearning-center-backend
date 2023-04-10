package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.entity.Course;
import com.sustech.entity.CourseAnnouncement;
import com.sustech.entity.User;
import com.sustech.service.CourseAnnouncementService;
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
@Api(tags = "CourseAnnouncementController")
@RestController
@RequestMapping("//courseAnnouncement")
public class CourseAnnouncementController {

    @Autowired
    public CourseAnnouncementService courseAnnouncementService;

    @ApiOperation(value = "获取所有课程通知")
    @GetMapping("/listCourseAnnouncement/{courseID}")
    public List<CourseAnnouncement> listCourseAnnouncement(@PathVariable Integer courseID) {
        QueryWrapper<CourseAnnouncement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseID);
        return courseAnnouncementService.list(queryWrapper);
    }
}


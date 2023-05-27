package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.entity.Course;
import com.sustech.entity.CourseAnnouncement;
import com.sustech.entity.User;
import com.sustech.service.CourseAnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@Api(tags = "CourseAnnouncementController")
@RestController
@RequestMapping("//courseAnnouncement")
public class CourseAnnouncementController {

    @Autowired
    public CourseAnnouncementService courseAnnouncementService;

    @ApiOperation(value = "获取所有课程通知")
    @GetMapping("/listCourseAnnouncement/{courseId}")
    public List<CourseAnnouncement> listCourseAnnouncement(@PathVariable Integer courseId) {
        QueryWrapper<CourseAnnouncement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId);
        return courseAnnouncementService.list(queryWrapper);
    }

    @ApiOperation(value = "增加新课程通知")
    @RequestMapping(value = "/addCourseAnnouncement/{courseId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean addCourseAnnouncement(@PathVariable int courseId, @RequestParam String subject, @RequestParam String content) {
        CourseAnnouncement courseAnnouncement = new CourseAnnouncement();
        courseAnnouncement.setCourseId(courseId);
        courseAnnouncement.setContent(content);
        courseAnnouncement.setSubject(subject);
        return courseAnnouncementService.save(courseAnnouncement);
    }

    @ApiOperation(value = "更新课程通知")
    @RequestMapping(value = "/updateCourseAnnouncement/{announcementId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCourseAnnouncement(@PathVariable int announcementId, @RequestParam String subject, @RequestParam String content) {
        CourseAnnouncement courseAnnouncement = new CourseAnnouncement();
        courseAnnouncement.setAnnouncementId(announcementId);
        courseAnnouncement.setContent(content);
        courseAnnouncement.setSubject(subject);
        courseAnnouncementService.updateById(courseAnnouncement);
    }

    @ApiOperation(value = "删除课程通知")
    @RequestMapping(value = "/deleteCourseAnnouncement/{announcementId}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteCourseAnnouncement(@PathVariable int announcementId) {
        return courseAnnouncementService.removeById(announcementId);
    }
}


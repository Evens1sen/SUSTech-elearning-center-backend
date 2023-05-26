package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.VO.CourseEventVO;
import com.sustech.entity.Course;
import com.sustech.entity.CourseAnnouncement;
import com.sustech.entity.CourseEvent;
import com.sustech.entity.User;
import com.sustech.service.CourseEventService;
import com.sustech.service.CourseService;
import com.sustech.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    public CourseService courseService;

    @Autowired
    public UserService userService;

    @ApiOperation(value = "获取学生的所有事件")
    @GetMapping("/getAllCourseEvents/{userID}")
    public List<CourseEventVO> getAllCourseEvents(@PathVariable Integer userID) {
        User user = userService.getById(userID);
        List<String> courseIDList = List.of(user.getCourseList().split(","));
        List<Course> courseList = courseService.listByIds(courseIDList);

        List<CourseEventVO> courseEventVOList = new ArrayList<>();
        for (Course course : courseList) {
            List<CourseEvent> courseEventList = listCourseEvent(course.getCourseId());
            for (CourseEvent courseEvent : courseEventList) {
                CourseEventVO courseEventVO = new CourseEventVO();
                courseEventVO.setCourseCode(course.getCourseCode());
                courseEventVO.setCourseName(course.getCourseName());
                BeanUtils.copyProperties(courseEvent, courseEventVO);
                courseEventVOList.add(courseEventVO);
            }
        }

        return courseEventVOList;
    }

    @ApiOperation(value = "获取课程所有除了Assignment与Project的event")
    @GetMapping("/listCourseEvent/{courseID}")
    public List<CourseEvent> listCourseEvent(@PathVariable Integer courseID) {
        QueryWrapper<CourseEvent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseID);
        queryWrapper.ne("event_type", "Assignment");
        queryWrapper.ne("event_type", "Project");
        return courseEventService.list(queryWrapper);
    }

    @ApiOperation(value = "根据类型获取课程所有event, Type: Lecture, Lab, Assignment, Project, Exam")
    @GetMapping("/listCourseEvent/{courseID}/{eventType}")
    public List<CourseEvent> listCourseEventByType(@PathVariable Integer courseID, @PathVariable String eventType) {
        QueryWrapper<CourseEvent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseID);
        queryWrapper.eq("event_type", eventType);
        return courseEventService.list(queryWrapper);
    }

    @ApiOperation(value = "增加新课程事件")
    @RequestMapping(value = "/addCourseEvent/{courseId}/{eventId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean addCourseEvent(@PathVariable int courseId , @PathVariable int eventId, String eventName, String eventType, String eventInstructor, String eventResources, LocalDateTime startTime, LocalDateTime endTime) {
        CourseEvent courseEvent = new CourseEvent();
        courseEvent.setCourseId(courseId);
        courseEvent.setEventId(eventId);
        courseEvent.setEventName(eventName);
        courseEvent.setEventType(eventType);
        courseEvent.setEventInstructor(eventInstructor);
        courseEvent.setEventResources(eventResources);
        courseEvent.setStartTime(startTime);
        courseEvent.setEndTime(endTime);
        return courseEventService.save(courseEvent);
    }

    @ApiOperation(value = "更新课程事件")
    @RequestMapping(value = "/updateCourseEvent/{courseId}/{eventId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCourseEvent(@PathVariable int courseId , @PathVariable int eventId, String eventName, String eventType, String eventInstructor, String eventResources, LocalDateTime startTime, LocalDateTime endTime) {
        courseEventService.updateCourseEvent(courseId,eventId,eventName,eventType,eventInstructor,eventResources,startTime,endTime);
    }

    @ApiOperation(value = "删除课程事件")
    @RequestMapping(value = "/deleteCourseEvent/{eventId}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteCourseEvent (@PathVariable int eventId) {
        return courseEventService.removeById(eventId);
    }



}


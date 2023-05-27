package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.VO.CourseEventVO;
import com.sustech.dto.CourseEventParam;
import com.sustech.entity.Course;
import com.sustech.entity.CourseEvent;
import com.sustech.entity.User;
import com.sustech.service.CourseEventService;
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
    @PostMapping(value = "/addCourseEvent/{courseId}")
    public boolean addCourseEvent(@PathVariable int courseId, @RequestBody CourseEventParam courseEventParam) {
        CourseEvent courseEvent = new CourseEvent();
        courseEvent.setCourseId(courseId);

        courseEvent.setEventName(courseEventParam.getEventName());
        courseEvent.setEventType(courseEventParam.getEventType());
        courseEvent.setEventInstructor(courseEventParam.getEventInstructor());
        courseEvent.setEventResources(courseEventParam.getEventResources());
        courseEvent.setStartTime(courseEventParam.getStartTime());
        courseEvent.setEndTime(courseEventParam.getEndTime());
        return courseEventService.save(courseEvent);
    }

    @ApiOperation(value = "更新课程事件")
    @PutMapping(value = "/updateCourseEvent/{courseId}/{eventId}")
    public void updateCourseEvent(@PathVariable int courseId, @PathVariable int eventId, @RequestBody CourseEventParam courseEventParam) {
        CourseEvent courseEvent = new CourseEvent();
        courseEvent.setCourseId(courseId);
        courseEvent.setEventId(eventId);
        BeanUtils.copyProperties(courseEventParam, courseEvent);
        courseEventService.updateById(courseEvent);
    }

    @ApiOperation(value = "删除课程事件")
    @DeleteMapping(value = "/deleteCourseEvent/{eventId}")
    public boolean deleteCourseEvent(@PathVariable int eventId) {
        return courseEventService.removeById(eventId);
    }

}


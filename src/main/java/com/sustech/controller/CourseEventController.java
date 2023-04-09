package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.VO.CourseEventVO;
import com.sustech.entity.Course;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}


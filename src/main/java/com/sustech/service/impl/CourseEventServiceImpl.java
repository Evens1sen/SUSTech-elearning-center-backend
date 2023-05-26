package com.sustech.service.impl;

import com.sustech.entity.CourseEvent;
import com.sustech.mapper.CourseEventMapper;
import com.sustech.service.CourseEventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Service
public class CourseEventServiceImpl extends ServiceImpl<CourseEventMapper, CourseEvent> implements CourseEventService {

    @Autowired
    CourseEventMapper courseEventMapper;

    @Override
    public void updateCourseEvent(int courseId, int eventId, String eventName, String eventType, String eventInstructor, String eventResources, LocalDateTime startTime, LocalDateTime endTime) {
        CourseEvent courseEvent = new CourseEvent();
        courseEvent.setCourseId(courseId);
        courseEvent.setEventId(eventId);
        courseEvent.setEventName(eventName);
        courseEvent.setEventType(eventType);
        courseEvent.setEventInstructor(eventInstructor);
        courseEvent.setEventResources(eventResources);
        courseEvent.setStartTime(startTime);
        courseEvent.setEndTime(endTime);
        courseEventMapper.update(courseEvent);
    }
}

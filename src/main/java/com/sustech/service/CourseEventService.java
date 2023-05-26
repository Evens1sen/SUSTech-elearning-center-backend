package com.sustech.service;

import com.sustech.entity.CourseEvent;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
public interface CourseEventService extends IService<CourseEvent> {

    void updateCourseEvent(int courseId ,int eventId, String eventName, String eventType, String eventInstructor, String eventResources, LocalDateTime startTime, LocalDateTime endTime);
}

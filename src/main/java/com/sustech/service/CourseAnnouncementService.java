package com.sustech.service;

import com.sustech.entity.CourseAnnouncement;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
public interface CourseAnnouncementService extends IService<CourseAnnouncement> {

    void updateCourseAnnouncement(int courseId , int announcementId, String subject, String content);

}

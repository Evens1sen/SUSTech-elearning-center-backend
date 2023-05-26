package com.sustech.service.impl;

import com.sustech.entity.CourseAnnouncement;
import com.sustech.mapper.CourseAnnouncementMapper;
import com.sustech.service.CourseAnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Service
public class CourseAnnouncementServiceImpl extends ServiceImpl<CourseAnnouncementMapper, CourseAnnouncement> implements CourseAnnouncementService {

    @Autowired
    public CourseAnnouncementMapper courseAnnouncementMapper;


    @Override
    public void updateCourseAnnouncement(int courseId, int announcementId, String subject, String content) {
        CourseAnnouncement courseAnnouncement = new CourseAnnouncement();
        courseAnnouncement.setAnnouncementId(announcementId);
        courseAnnouncement.setCourseId(courseId);
        courseAnnouncement.setContent(content);
        courseAnnouncement.setSubject(subject);
        courseAnnouncementMapper.update(courseAnnouncement);
    }
}

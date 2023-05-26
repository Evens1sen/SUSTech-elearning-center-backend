package com.sustech.service.impl;

import com.sustech.entity.Course;
import com.sustech.entity.CourseAnnouncement;
import com.sustech.mapper.CourseAnnouncementMapper;
import com.sustech.mapper.CourseMapper;
import com.sustech.service.CourseService;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    public CourseMapper courseMapper;


    @Override
    public void updateCourse(int courseId ,String courseCode, String semester, String instructor, String courseName,String description) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseCode(courseCode);
        course.setSemester(semester);
        course.setInstructor(instructor);
        course.setCourseName(courseName);
        course.setDescription(description);
        courseMapper.update(course);
    }
}

package com.sustech.service;

import com.sustech.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
public interface CourseService extends IService<Course> {

    void updateCourse(int courseId ,String courseCode, String semester, String instructor, String courseName,String description);
}

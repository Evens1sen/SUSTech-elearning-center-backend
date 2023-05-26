package com.sustech.mapper;

import com.sustech.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {
    @Update("       UPDATE\n" +
            "       course \n" +
            "       SET \n" +
            "       course_id = #{courseId}," +
            "       course_code = #{courseCode}," +
            "       semester = #{semester}," +
            "       instructor = #{instructor}," +
            "       course_name = #{courseName}," +
            "       description = #{description}\n" +
            "       WHERE \n" +
            "       course_id = #{course_id}")
    void update(Course course);
}

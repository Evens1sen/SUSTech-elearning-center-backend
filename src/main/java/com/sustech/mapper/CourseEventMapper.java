package com.sustech.mapper;

import com.sustech.entity.Course;
import com.sustech.entity.CourseEvent;
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
public interface CourseEventMapper extends BaseMapper<CourseEvent> {
    @Update("       UPDATE\n" +
            "       course_event \n" +
            "       SET \n" +
            "       event_id = #{eventId}," +
            "       course_id = #{courseId}," +
            "       event_name = #{eventName}," +
            "       event_type = #{eventType}," +
            "       event_instructor = #{eventInstructor}," +
            "       event_resources = #{eventResources}," +
            "       start_time = #{startTime}," +
            "       end_time = #{endTime}\n" +
            "       WHERE \n" +
            "       event_id = #{eventId}")
    void update(CourseEvent courseEvent);
}

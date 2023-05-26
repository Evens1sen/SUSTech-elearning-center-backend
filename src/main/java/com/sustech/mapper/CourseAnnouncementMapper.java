package com.sustech.mapper;

import com.sustech.entity.CourseAnnouncement;
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
public interface CourseAnnouncementMapper extends BaseMapper<CourseAnnouncement> {
    @Update("       UPDATE\n" +
            "       course_announcement \n" +
            "       SET \n" +
            "       announcement_id = #{announcementId}," +
            "       course_id = #{courseId}," +
            "       subject = #{subject}," +
            "       content = #{content}\n" +
            "       WHERE \n" +
            "       course_id = #{course_id} and announcement_id = #{announcementId}")
    void update(CourseAnnouncement courseAnnouncement);

}

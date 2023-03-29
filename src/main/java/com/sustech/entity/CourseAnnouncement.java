package com.sustech.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseAnnouncement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "announcement_id", type = IdType.AUTO)
    private Integer announcementId;

    private Integer courseId;

    private String subject;

    private String content;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

}

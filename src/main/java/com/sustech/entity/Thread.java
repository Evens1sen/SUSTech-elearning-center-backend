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
public class Thread implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "thread_id", type = IdType.AUTO)
    private Integer threadId;

    private Integer userId;

    private String category;

    private String threadTitle;

    private String threadBody;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

}

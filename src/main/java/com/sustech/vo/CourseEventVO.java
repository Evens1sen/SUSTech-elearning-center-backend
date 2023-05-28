package com.sustech.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseEventVO {

    private String courseCode;

    private String courseName;

    private String eventType;

    private String eventName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}

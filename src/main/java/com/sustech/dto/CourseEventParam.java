package com.sustech.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class CourseEventParam {

    private String eventType;

    private String eventName;

    private String eventInstructor;

    private String eventResources;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}

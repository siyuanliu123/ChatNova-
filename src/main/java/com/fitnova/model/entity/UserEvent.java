package com.fitnova.model.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
public class UserEvent {
    private Integer eventId;
    private String title;
    private String description;
    private String location;
    private Date date;
    private Time time;
    private Integer createdBy;
    private Boolean isReported;
}

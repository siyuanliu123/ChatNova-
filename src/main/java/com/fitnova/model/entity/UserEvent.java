package com.fitnova.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserEvent {
    private Integer eventId;
    private Integer userId;
    private String eventName;
    private String eventType; // webinar, workshop, meetup
    private Timestamp eventDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

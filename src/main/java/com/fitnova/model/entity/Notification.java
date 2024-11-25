package com.fitnova.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Notification {
    private Integer id;
    private Integer userId;
    private String type;
    private Integer referenceId;
    private Boolean isRead;
    private Timestamp createdAt;
}

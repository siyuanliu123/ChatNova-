package com.fitnova.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Message {
    private Integer id;
    private Integer senderId;
    private Integer receiverId;
    private String content;
    private Timestamp createdAt;
}

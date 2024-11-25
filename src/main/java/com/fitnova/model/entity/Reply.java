package com.fitnova.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Reply {
    private Integer id;
    private Integer commentId;
    private Integer userId;
    private String content;
    private Timestamp createdAt;
}


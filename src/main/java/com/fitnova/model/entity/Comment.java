package com.fitnova.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
    private Integer id;
    private Integer postId;
    private Integer userId;
    private String content;
    private Integer likesCount;
    private Timestamp createdAt;
}


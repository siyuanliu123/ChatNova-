package com.fitnova.model.entity;

import java.util.Date;

import lombok.Data;

@Data
public class CommentLike {
    private Long id;
    private Long commentId;
    private Long userId;
    private Date createTime;
} 
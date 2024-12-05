package com.fitnova.model.entity;

import java.util.Date;

import lombok.Data;

@Data
public class PostLike {
    private Long id;
    private Long postId;
    private Long userId;
    private Date createTime;
} 
package com.fitnova.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Like {
    private Long id;
    private Long postId;
    private Long userId;
    private Date createTime;
}


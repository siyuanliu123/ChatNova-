package com.fitnova.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private Long id;
    private Long userId;
    private String content;
    private Date createTime;
    private Integer likeCount;
    private Integer commentCount;
}

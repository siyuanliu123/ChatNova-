package com.fitnova.model.entity;

import lombok.Data;
import java.util.Date;

@Data
public class UserSettings {
    private Long id;
    private Long userId;
    private Long postId; // 关联的帖子ID
//    private Boolean DarkMode;//KEVIN: ADD THIS FOR IMPL
    private Boolean notifications; // 是否启用通知
    private String language; // 用户语言偏好
    private Date createTime;
    private Date updateTime;
}


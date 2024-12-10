package com.fitnova.model.entity;

import java.time.LocalDateTime;
import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Boolean onlineStatus; // 是否在线
    private String avatar; // 头像路径
    private Date createTime;
    private Date updateTime;

    private String profilePicture; // 新增字段：用户头像
    private String bio; // 新增字段：个人简介
    private Boolean isActive; // 新增字段：用户是否激活
    private String userType; // 新增字段：用户类型（user, coach）

    // Getters and Setters
}

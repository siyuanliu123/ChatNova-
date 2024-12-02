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

    // Getters and Setters
}

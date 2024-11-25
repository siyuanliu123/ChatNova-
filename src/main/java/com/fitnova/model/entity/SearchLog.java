package com.fitnova.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SearchLog {
    private Integer id;
    private Integer userId;
    private String keyword;
    private Timestamp createdAt;
}

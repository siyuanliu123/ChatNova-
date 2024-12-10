package com.fitnova.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Income {
    private Integer incomeId;
    private Integer coachId;
    private String source; // course, event
    private Double amount;
    private Timestamp createdAt;
}


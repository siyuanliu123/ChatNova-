package com.fitnova.model.entity;

import lombok.Data;

@Data
public class Coach {
    private Integer coachId;
    private String verificationStatus; // pending, verified, rejected
    private String specialty;
    private Double rating;
    private String bio;
}


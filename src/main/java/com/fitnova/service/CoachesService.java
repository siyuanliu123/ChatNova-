package com.fitnova.service;

import com.fitnova.model.entity.Coach;

public interface CoachesService {
    int registerCoach(Coach coach);
    Coach getCoachById(Integer coachId);
    int updateCoach(Coach coach);
}

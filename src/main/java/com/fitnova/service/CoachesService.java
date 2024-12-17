package com.fitnova.service;

import com.fitnova.model.entity.Coach;

public interface CoachesService {
    void registerCoach(Coach coach);

    Coach getCoachById(Integer coachId);

    boolean updateCoach(Coach coach);

    boolean isUserExists(Integer userId);

}

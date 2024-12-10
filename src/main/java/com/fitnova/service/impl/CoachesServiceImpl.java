package com.fitnova.service.impl;

import com.fitnova.mapper.CoachesMapper;
import com.fitnova.model.entity.Coach;
import com.fitnova.service.CoachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachesServiceImpl implements CoachesService {

    @Autowired
    private CoachesMapper coachesMapper;

    @Override
    public int registerCoach(Coach coach) {
        return coachesMapper.registerCoach(coach);
    }

    @Override
    public Coach getCoachById(Integer coachId) {
        return coachesMapper.findCoachById(coachId);
    }

    @Override
    public int updateCoach(Coach coach) {
        return coachesMapper.updateCoach(coach);
    }
}

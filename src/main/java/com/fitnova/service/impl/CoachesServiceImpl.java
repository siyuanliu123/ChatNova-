package com.fitnova.service.impl;

import com.fitnova.mapper.CoachesMapper;
import com.fitnova.mapper.UserMapper;
import com.fitnova.model.entity.Coach;
import com.fitnova.service.CoachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachesServiceImpl implements CoachesService {

    @Autowired
    private CoachesMapper coachesMapper;

    @Autowired
    private UserMapper UserMapper;

    @Override
    public void registerCoach(Coach coach) {
        coachesMapper.insertCoach(coach);
    }

    @Override
    public Coach getCoachById(Integer coachId) {
        return coachesMapper.findById(coachId);
    }

    @Override
    public boolean updateCoach(Coach coach) {
        int rowsAffected = coachesMapper.updateCoach(coach);
        return rowsAffected > 0; // 返回是否更新成功
    }

    @Override
    public boolean isUserExists(Integer userId) {
        return UserMapper.countById(userId) > 0;
    }

}

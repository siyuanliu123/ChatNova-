package com.fitnova.service.impl;

import com.fitnova.mapper.IncomeMapper;
import com.fitnova.mapper.CoachesMapper;
import com.fitnova.model.entity.Income;
import com.fitnova.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeMapper incomeMapper;

    @Autowired
    private CoachesMapper CoachesMapper;

    @Override
    public boolean coachExists(Integer coachId) {
        return CoachesMapper.findById(coachId) != null;
    }

    @Override
    public void addIncome(Income income) {
        incomeMapper.addIncome(income);
    }


    @Override
    public List<Income> getIncomeByCoachId(Integer coachId) {
        return incomeMapper.findIncomeByCoachId(coachId);
    }
}

package com.fitnova.service.impl;

import com.fitnova.mapper.IncomeMapper;
import com.fitnova.model.entity.Income;
import com.fitnova.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeMapper incomeMapper;

    @Override
    public int addIncome(Income income) {
        return incomeMapper.addIncome(income);
    }

    @Override
    public List<Income> getIncomeByCoachId(Integer coachId) {
        return incomeMapper.findIncomeByCoachId(coachId);
    }
}

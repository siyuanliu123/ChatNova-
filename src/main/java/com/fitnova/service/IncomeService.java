package com.fitnova.service;

import com.fitnova.model.entity.Income;

import java.util.List;

public interface IncomeService {
    int addIncome(Income income);
    List<Income> getIncomeByCoachId(Integer coachId);
}

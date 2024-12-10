package com.fitnova.controller;

import com.fitnova.model.entity.Income;
import com.fitnova.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping("/{coachId}")
    public String addIncome(@PathVariable Integer coachId, @RequestBody Income income) {
        income.setCoachId(coachId);
        incomeService.addIncome(income);
        return "Income record added!";
    }

    @GetMapping("/{coachId}")
    public List<Income> getIncomeByCoach(@PathVariable Integer coachId) {
        return incomeService.getIncomeByCoachId(coachId);
    }
}

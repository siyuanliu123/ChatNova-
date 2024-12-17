package com.fitnova.controller;

import com.fitnova.model.entity.Income;
import com.fitnova.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping("/{coachId}")
    public ResponseEntity<String> addIncome(@PathVariable Integer coachId, @RequestBody Income income) {
        // 定义允许的 source 值
        List<String> validSources = Arrays.asList("course", "event");

        // 校验 source 值
        if (income.getSource() == null || !validSources.contains(income.getSource())) {
            return ResponseEntity.badRequest().body("Invalid source value");
        }

        // 校验 coachId 是否存在
        if (!incomeService.coachExists(coachId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coach not found");
        }

        // 设置 coachId 并保存记录
        income.setCoachId(coachId);
        incomeService.addIncome(income);
        return ResponseEntity.ok("Income record added!");
    }


    @GetMapping("/{coachId}")
    public List<Income> getIncomeByCoach(@PathVariable Integer coachId) {
        return incomeService.getIncomeByCoachId(coachId);
    }
}

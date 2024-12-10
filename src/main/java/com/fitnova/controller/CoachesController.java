package com.fitnova.controller;

import com.fitnova.model.entity.Coach;
import com.fitnova.service.CoachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coaches")
public class CoachesController {

    @Autowired
    private CoachesService coachesService;

    @PostMapping("/register")
    public String registerCoach(@RequestBody Coach coach) {
        coachesService.registerCoach(coach);
        return "Coach registration submitted!";
    }

    @GetMapping("/{coachId}")
    public Coach getCoach(@PathVariable Integer coachId) {
        return coachesService.getCoachById(coachId);
    }

    @PutMapping("/{coachId}")
    public String updateCoach(@PathVariable Integer coachId, @RequestBody Coach coach) {
        coach.setCoachId(coachId);
        coachesService.updateCoach(coach);
        return "Coach updated successfully!";
    }
}

package com.fitnova.controller;

import com.fitnova.model.entity.Coach;
import com.fitnova.service.CoachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachesController {

    @Autowired
    private CoachesService coachesService;

    private static final List<String> VALID_STATUSES = Arrays.asList("pending", "verified", "rejected");

    @PostMapping("/register")
    public ResponseEntity<String> registerCoach(@RequestBody Coach coach) {
        // 检查 Users 表中是否存在对应的 user_id
        if (!coachesService.isUserExists(coach.getCoachId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User ID does not exist in Users table");
        }

        // 校验 verificationStatus
        if (!VALID_STATUSES.contains(coach.getVerificationStatus())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid verification status");
        }

        // 插入教练记录
        coachesService.registerCoach(coach);
        return ResponseEntity.status(HttpStatus.CREATED).body("Coach registration submitted!");
    }


    @GetMapping("/{coachId}")
    public ResponseEntity<?> getCoach(@PathVariable Integer coachId) {
        Coach coach = coachesService.getCoachById(coachId);
        if (coach == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Coach not found");
        }
        return ResponseEntity.ok(coach);
    }

    @PutMapping("/{coachId}")
    public ResponseEntity<String> updateCoach(@PathVariable Integer coachId, @RequestBody Coach coach) {
        if (!VALID_STATUSES.contains(coach.getVerificationStatus())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid verification status");
        }
        // 设置 coachId
        coach.setCoachId(coachId);
        boolean updated = coachesService.updateCoach(coach);

        if (!updated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Coach not found");
        }
        return ResponseEntity.ok("Coach updated successfully!");
    }
}

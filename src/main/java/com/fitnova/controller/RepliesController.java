package com.fitnova.controller;

import com.fitnova.model.entity.Reply;
import com.fitnova.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/replies")
public class RepliesController {
    @Autowired
    private RepliesService repliesService;

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<?> getRepliesByCommentId(@PathVariable Integer commentId) {
        try {
            List<Reply> replies = repliesService.getRepliesByCommentId(commentId);
            return ResponseEntity.ok(replies); // 存在数据时返回 200 OK
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No replies found for commentId " + commentId);
        }
    }

    @PostMapping
    public void createReply(@RequestBody Reply reply) {
        repliesService.createReply(reply);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Integer id) {
        try {
            repliesService.deleteReply(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}


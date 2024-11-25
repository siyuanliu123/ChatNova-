package com.fitnova.controller;

import com.fitnova.model.entity.Reply;
import com.fitnova.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/replies")
public class RepliesController {
    @Autowired
    private RepliesService repliesService;

    @GetMapping("/comment/{commentId}")
    public List<Reply> getRepliesByCommentId(@PathVariable Integer commentId) {
        return repliesService.getRepliesByCommentId(commentId);
    }

    @PostMapping
    public void createReply(@RequestBody Reply reply) {
        repliesService.createReply(reply);
    }

    @DeleteMapping("/{id}")
    public void deleteReply(@PathVariable Integer id) {
        repliesService.deleteReply(id);
    }
}


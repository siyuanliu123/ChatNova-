package com.fitnova.controller;

import com.fitnova.model.entity.Comment;
import com.fitnova.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentsService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Integer id) {
        return commentsService.getCommentById(id);
    }

    @PostMapping
    public void createComment(@RequestBody Comment comment) {
        commentsService.createComment(comment);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Integer id, @RequestBody Comment comment) {
        comment.setId(id);
        commentsService.updateComment(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentsService.deleteComment(id);
    }
}


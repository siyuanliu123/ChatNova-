package com.fitnova.controller;

import com.fitnova.model.entity.Comment;
import com.fitnova.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        try {
            Comment comment = commentsService.getCommentById(id);
            return ResponseEntity.ok(comment); // 存在记录时返回 200 OK
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 不存在记录时返回 404
        }
    }

    @PostMapping
    public void createComment(@RequestBody Comment comment) {
        commentsService.createComment(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer id, @RequestBody Comment comment) {
        try {
            comment.setId(id); // 设置评论 ID
            commentsService.updateComment(comment);
            return ResponseEntity.ok(comment); // 返回 200 OK 和更新后的评论
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment with id " + id + " does not exist");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request body");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        try {
            commentsService.deleteComment(id);
            return ResponseEntity.noContent().build(); // 返回 204 No Content
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 返回 404 Not Found
        }
    }
}


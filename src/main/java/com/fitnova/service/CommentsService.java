package com.fitnova.service;

import com.fitnova.model.entity.Comment;

import java.util.List;

public interface CommentsService {
    List<Comment> getAllComments();
    Comment getCommentById(Integer id);
    void createComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(Integer id);
}


package com.fitnova.service.impl;

import com.fitnova.mapper.CommentsMapper;
import com.fitnova.model.entity.Comment;
import com.fitnova.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public List<Comment> getAllComments() {
        return commentsMapper.findAll();
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentsMapper.findById(id);
    }

    @Override
    public void createComment(Comment comment) {
        commentsMapper.insert(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentsMapper.update(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentsMapper.deleteById(id);
    }
}


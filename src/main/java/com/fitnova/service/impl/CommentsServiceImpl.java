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
        Comment comment = commentsMapper.findById(id);
        if (comment == null) {
            throw new IllegalStateException("Comment with id " + id + " does not exist");
        }
        return comment;
    }

    @Override
    public void createComment(Comment comment) {
        commentsMapper.insert(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        if (comment.getContent() == null || comment.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be empty");
        }

        int rowsAffected = commentsMapper.update(comment);
        if (rowsAffected == 0) {
            throw new IllegalStateException("Comment with id " + comment.getId() + " does not exist");
        }
    }

    @Override
    public void deleteComment(Integer id) {
        commentsMapper.deleteRepliesByCommentId(id); // 先删除关联的回复
        commentsMapper.deleteLikesByCommentId(id);  // 再删除关联的点赞记录
        // 最后删除评论，校验返回值
        int rowsAffected = commentsMapper.deleteById(id);
        if (rowsAffected == 0) {
            throw new IllegalStateException("Comment with id " + id + " does not exist");
        }
    }
}


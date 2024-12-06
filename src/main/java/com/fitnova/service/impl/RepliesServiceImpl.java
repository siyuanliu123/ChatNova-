package com.fitnova.service.impl;

import com.fitnova.mapper.RepliesMapper;
import com.fitnova.model.entity.Reply;
import com.fitnova.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepliesServiceImpl implements RepliesService {
    @Autowired
    private RepliesMapper repliesMapper;

    @Override
    public List<Reply> getRepliesByCommentId(Integer commentId) {
        List<Reply> replies = repliesMapper.findByCommentId(commentId);
        if (replies == null || replies.isEmpty()) {
            throw new IllegalStateException("No replies found for commentId " + commentId);
        }
        return replies;
    }

    @Override
    public void createReply(Reply reply) {
        repliesMapper.insert(reply);
    }

    @Override
    public void deleteReply(Integer id) {
        int rowsAffected = repliesMapper.deleteById(id);
        if (rowsAffected == 0) {
            throw new IllegalStateException("Reply with id " + id + " does not exist");
        }
    }
}


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
        return repliesMapper.findByCommentId(commentId);
    }

    @Override
    public void createReply(Reply reply) {
        repliesMapper.insert(reply);
    }

    @Override
    public void deleteReply(Integer id) {
        repliesMapper.deleteById(id);
    }
}


package com.fitnova.service;

import com.fitnova.model.entity.Reply;

import java.util.List;

public interface RepliesService {
    List<Reply> getRepliesByCommentId(Integer commentId);
    void createReply(Reply reply);
    void deleteReply(Integer id);
}


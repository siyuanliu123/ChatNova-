package com.fitnova.service;

import com.fitnova.model.entity.Post;
import com.fitnova.model.entity.Comment;

import java.util.List;

public interface PostService {
    Long createPost(Post post);
    boolean likePost(Long postId, Long userId);
    boolean unlikePost(Long postId, Long userId);
    Integer addComment(Comment comment);
    List<Comment> getCommentsByPostId(Long postId);
}


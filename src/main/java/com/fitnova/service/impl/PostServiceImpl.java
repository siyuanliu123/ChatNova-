package com.fitnova.service.impl;

import com.fitnova.mapper.CommentsMapper;
import com.fitnova.mapper.LikeMapper;
import com.fitnova.mapper.PostMapper;
import com.fitnova.model.entity.Post;
import com.fitnova.model.entity.Comment;
import com.fitnova.model.entity.Like;
import com.fitnova.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private CommentsMapper commentMapper;

    public Long createPost(Post post) {
        postMapper.insertPost(post);
        return post.getId();
    }

    @Override
    public boolean likePost(Long postId, Long userId) {
        if (likeMapper.isLikedByUser(postId, userId) > 0) {
            return false; // Already liked
        }
        Like like = new Like();
        like.setPostId(postId);
        like.setUserId(userId);
        likeMapper.insertLike(like);
        postMapper.incrementLikeCount(postId);
        return true;
    }

    @Override
    public boolean unlikePost(Long postId, Long userId) {
        if (likeMapper.isLikedByUser(postId, userId) == 0) {
            return false; // Not liked yet
        }
        likeMapper.deleteLike(postId, userId);
        return true;
    }

    @Override
    public Integer addComment(Comment comment) {
        commentMapper.insertComment(comment);
        postMapper.incrementCommentCount(Long.valueOf(comment.getPostId()));
        return comment.getId();
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentMapper.findCommentsByPostId(postId);
    }
}


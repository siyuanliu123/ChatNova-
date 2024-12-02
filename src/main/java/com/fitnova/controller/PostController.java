package com.fitnova.controller;

import com.fitnova.model.entity.Post;
import com.fitnova.model.entity.Comment;
import com.fitnova.service.PostService;
import com.fitnova.model.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseVO<String> createPost(@RequestBody Post post) {
        String postId = String.valueOf(postService.createPost(post));
        return ResponseVO.success(postId);
    }

    @PostMapping("/{postId}/like")
    public ResponseVO<?> likePost(@PathVariable Long postId, @RequestParam Long userId) {
        if (postService.likePost(postId, userId)) {
            return ResponseVO.success("Liked successfully");
        }
        return ResponseVO.error("Already liked");
    }

    @DeleteMapping("/{postId}/like")
    public ResponseVO<?> unlikePost(@PathVariable Long postId, @RequestParam Long userId) {
        if (postService.unlikePost(postId, userId)) {
            return ResponseVO.success("Unliked successfully");
        }
        return ResponseVO.error("Not liked yet");
    }

    @PostMapping("/{postId}/comments")
    public ResponseVO addComment(@PathVariable Integer postId, @RequestBody Comment comment) {
        comment.setPostId(postId);
        Integer commentId = postService.addComment(comment);
        return ResponseVO.success(String.valueOf(commentId));
    }

    @GetMapping("/{postId}/comments")
    public ResponseVO getComments(@PathVariable Long postId) {
        List<Comment> comments = postService.getCommentsByPostId(postId);
        return ResponseVO.success(comments.toString());
    }
}


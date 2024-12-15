package service;

import com.fitnova.mapper.CommentsMapper;
import com.fitnova.mapper.LikeMapper;
import com.fitnova.mapper.PostMapper;
import com.fitnova.model.entity.Comment;
import com.fitnova.model.entity.Like;
import com.fitnova.model.entity.Post;
import com.fitnova.service.PostService;
import com.fitnova.service.impl.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PostServiceTest {

    @Mock
    private PostMapper postMapper;

    @Mock
    private LikeMapper likeMapper;

    @Mock
    private CommentsMapper commentMapper;

    @InjectMocks
    private PostServiceImpl postService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePost() {
        Post post = new Post();
        post.setUserId(1L);
        post.setContent("Test content");

        doAnswer(invocation -> {
            post.setId(1L); // Simulate generated key
            return 1;
        }).when(postMapper).insertPost(post);

        Long postId = postService.createPost(post);
        assertEquals(1L, postId);
        verify(postMapper, times(1)).insertPost(post);
    }

    @Test
    void testIncrementLikeCount() {
        Long postId = 1L;
        Long userId = 2L;

        when(likeMapper.isLikedByUser(postId, userId)).thenReturn(0); // Not liked yet

        boolean result = postService.likePost(postId, userId);
        assertTrue(result);

        verify(likeMapper, times(1)).isLikedByUser(postId, userId);
        verify(likeMapper, times(1)).insertLike(any(Like.class));
        verify(postMapper, times(1)).incrementLikeCount(postId);
    }

    @Test
    void testLikePost() {
        Long postId = 1L;
        Long userId = 2L;

        when(likeMapper.isLikedByUser(postId, userId)).thenReturn(0);

        boolean result = postService.likePost(postId, userId);
        assertTrue(result);

        verify(likeMapper, times(1)).isLikedByUser(postId, userId);
        verify(likeMapper, times(1)).insertLike(any(Like.class));
        verify(postMapper, times(1)).incrementLikeCount(postId);
    }

    @Test
    void testUnlikePost() {
        Long postId = 1L;
        Long userId = 2L;

        when(likeMapper.isLikedByUser(postId, userId)).thenReturn(1);

        boolean result = postService.unlikePost(postId, userId);

        assertTrue(result);

        verify(likeMapper, times(1)).isLikedByUser(postId, userId);
        verify(likeMapper, times(1)).deleteLike(postId,userId);
    }

    @Test
    void testAddComment() {
        Comment comment = new Comment();
        comment.setContent("Test comment");
        comment.setPostId(1);

        doAnswer(invocation -> {
            comment.setId(1);
            return 1;
        }).when(commentMapper).insertComment(comment);

        Integer commentId = postService.addComment(comment);
        assertEquals(1, commentId);
        verify(commentMapper, times(1)).insertComment(comment);
        verify(postMapper, times(1)).incrementCommentCount(1L);
    }

    @Test
    void testGetCommentsByPostId() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setContent("Test comment");

        // have issues with the postId being an integer in the entity class
        when(commentMapper.findCommentsByPostId(1L)).thenReturn(Collections.singletonList(comment));
        List<Comment> comments = postService.getCommentsByPostId(1L);
        assertEquals(1, comments.size());
        assertEquals("Test comment", comments.get(0).getContent());
        verify(commentMapper, times(1)).findCommentsByPostId(1L);
    }
}

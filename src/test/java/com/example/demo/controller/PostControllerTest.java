package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitnova.controller.PostController;
import com.fitnova.model.entity.Comment;
import com.fitnova.model.entity.Post;
import com.fitnova.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreatePost() throws Exception {
        Post post = new Post();
        post.setUserId(1L);
        post.setContent("This is a test post.");

        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNumber())
                .andDo(print());
    }

    @Test
    public void testLikePost() throws Exception {
        mockMvc.perform(post("/posts/1/like")
                        .param("userId", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("Post liked"))
                .andDo(print());
    }

    @Test
    public void testLikePostAlreadyLiked() throws Exception {
        mockMvc.perform(post("/posts/1/like")
                        .param("userId", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.errorMessage").value("Post already liked"))
                .andDo(print());
    }

    @Test
    public void testUnlikePost() throws Exception {
        mockMvc.perform(post("/posts/1/unlike")
                        .param("userId", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("Post unliked"))
                .andDo(print());
    }

    @Test
    public void testAddComment() throws Exception {
        Comment comment = new Comment();
        comment.setContent("This is a test comment.");

        mockMvc.perform(post("/posts/1/comments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNumber())
                .andDo(print());
    }

    @Test
    public void testGetComments() throws Exception {
        mockMvc.perform(get("/posts/1/comments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andDo(print());
    }

    @Test
    public void testGetCommentsEmpty() throws Exception {
        mockMvc.perform(get("/posts/999/comments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isEmpty())
                .andDo(print());
    }

}

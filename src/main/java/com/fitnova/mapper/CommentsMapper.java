package com.fitnova.mapper;

import com.fitnova.model.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentsMapper {
    List<Comment> findAll();
    Comment findById(Integer id);
    void insert(Comment comment);
    void update(Comment comment);
    void deleteById(Integer id);

    //Leon
    @Insert("INSERT INTO tb_comment (post_id, user_id, content, create_time) VALUES (#{postId}, #{userId}, #{content}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertComment(Comment comment);

    @Select("SELECT * FROM tb_comment WHERE post_id = #{postId} ORDER BY create_time DESC")
    List<Comment> findCommentsByPostId(Long postId);
}

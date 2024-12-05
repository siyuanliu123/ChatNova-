package com.fitnova.mapper;

import com.fitnova.model.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentsMapper {

    // 查询所有评论
    @Select("SELECT * FROM Comments")
    List<Comment> findAll();

    // 根据 ID 查询评论
    @Select("SELECT * FROM Comments WHERE id = #{id}")
    Comment findById(Integer id);

    // 插入新评论
    @Insert("INSERT INTO Comments (post_id, user_id, content, likes_count, created_at) " +
            "VALUES (#{postId}, #{userId}, #{content}, #{likesCount}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Comment comment);

    // 更新评论
    @Update("UPDATE Comments SET post_id = #{postId}, user_id = #{userId}, content = #{content}, likes_count = #{likesCount} " +
            "WHERE id = #{id}")
    void update(Comment comment);

    // 根据 ID 删除评论
    @Delete("DELETE FROM Comments WHERE id = #{id}")
    void deleteById(Integer id);

    // 根据帖子 ID 查询评论
    @Select("SELECT * FROM Comments WHERE post_id = #{postId} ORDER BY created_at DESC")
    List<Comment> findCommentsByPostId(Integer postId);
}



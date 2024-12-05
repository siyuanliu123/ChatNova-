package com.fitnova.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fitnova.model.entity.CommentLike;

@Mapper
public interface CommentLikeMapper {

    @Insert("INSERT INTO tb_comment_like (comment_id, user_id, create_time) VALUES (#{commentId}, #{userId}, NOW())")
    int insertCommentLike(CommentLike commentLike);

    @Delete("DELETE FROM tb_comment_like WHERE comment_id = #{commentId} AND user_id = #{userId}")
    int deleteCommentLike(@Param("commentId") Long commentId, @Param("userId") Long userId);

    @Select("SELECT COUNT(*) FROM tb_comment_like WHERE comment_id = #{commentId} AND user_id = #{userId}")
    int isCommentLikedByUser(@Param("commentId") Long commentId, @Param("userId") Long userId);
} 
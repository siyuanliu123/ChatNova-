package com.fitnova.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fitnova.model.entity.PostLike;

@Mapper
public interface PostLikeMapper {

    @Insert("INSERT INTO tb_post_like (post_id, user_id, create_time) VALUES (#{postId}, #{userId}, NOW())")
    int insertPostLike(PostLike postLike);

    @Delete("DELETE FROM tb_post_like WHERE post_id = #{postId} AND user_id = #{userId}")
    int deletePostLike(@Param("postId") Long postId, @Param("userId") Long userId);

    @Select("SELECT COUNT(*) FROM tb_post_like WHERE post_id = #{postId} AND user_id = #{userId}")
    int isPostLikedByUser(@Param("postId") Long postId, @Param("userId") Long userId);
} 
package com.fitnova.mapper;

import com.fitnova.model.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO tb_post (user_id, content, create_time, like_count, comment_count) VALUES (#{userId}, #{content}, NOW(), 0, 0)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPost(Post post);

    @Update("UPDATE tb_post SET like_count = like_count + 1 WHERE id = #{postId}")
    int incrementLikeCount(Long postId);

    @Update("UPDATE tb_post SET comment_count = comment_count + 1 WHERE id = #{postId}")
    int incrementCommentCount(Long postId);

    @Select("SELECT * FROM tb_post WHERE id = #{postId}")
    Post findPostById(Long postId);
}

package com.fitnova.mapper;

import com.fitnova.model.entity.Like;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LikeMapper {

    @Insert("INSERT INTO tb_like (post_id, user_id, create_time) VALUES (#{postId}, #{userId}, NOW())")
    int insertLike(Like like);

    @Delete("DELETE FROM tb_like WHERE post_id = #{postId} AND user_id = #{userId}")
    int deleteLike(@Param("postId") Long postId, @Param("userId") Long userId);

    @Select("SELECT COUNT(*) FROM tb_like WHERE post_id = #{postId} AND user_id = #{userId}")
    int isLikedByUser(@Param("postId") Long postId, @Param("userId") Long userId);
}

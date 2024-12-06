package com.fitnova.mapper;

import com.fitnova.model.entity.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RepliesMapper {

    // 根据评论 ID 查询回复
    @Select("SELECT * FROM Replies WHERE comment_id = #{commentId}")
    List<Reply> findByCommentId(Integer commentId);

    @Insert("INSERT INTO Replies (comment_id, user_id, content, created_at) " +
            "VALUES (#{commentId}, #{userId}, #{content}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Reply reply);

    // 根据回复 ID 删除回复
    @Delete("DELETE FROM Replies WHERE id = #{id}")
    int deleteById(Integer id);
}


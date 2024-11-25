package com.fitnova.mapper;

import com.fitnova.model.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepliesMapper {
    List<Reply> findByCommentId(Integer commentId);
    void insert(Reply reply);
    void deleteById(Integer id);
}


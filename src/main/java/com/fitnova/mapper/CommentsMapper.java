package com.fitnova.mapper;

import com.fitnova.model.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsMapper {
    List<Comment> findAll();
    Comment findById(Integer id);
    void insert(Comment comment);
    void update(Comment comment);
    void deleteById(Integer id);
}

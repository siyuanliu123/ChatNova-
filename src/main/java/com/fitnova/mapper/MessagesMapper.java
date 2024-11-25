package com.fitnova.mapper;

import com.fitnova.model.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessagesMapper {
    List<Message> findByUserId(Integer userId);
    void insert(Message message);
    void deleteById(Integer id);
}

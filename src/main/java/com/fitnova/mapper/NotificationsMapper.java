package com.fitnova.mapper;

import com.fitnova.model.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationsMapper {
    List<Notification> findByUserId(Integer userId);
    void markAsRead(Integer id);
    void insert(Notification notification);
    void deleteById(Integer id);
}


package com.fitnova.service.impl;

import com.fitnova.mapper.NotificationsMapper;
import com.fitnova.model.entity.Notification;
import com.fitnova.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsServiceImpl implements NotificationsService {
    @Autowired
    private NotificationsMapper notificationsMapper;

    @Override
    public List<Notification> getNotificationsByUserId(Integer userId) {
        return notificationsMapper.findByUserId(userId);
    }

    @Override
    public void markNotificationAsRead(Integer id) {
        notificationsMapper.markAsRead(id);
    }

    @Override
    public void createNotification(Notification notification) {
        notificationsMapper.insert(notification);
    }

    @Override
    public void deleteNotification(Integer id) {
        notificationsMapper.deleteById(id);
    }
}


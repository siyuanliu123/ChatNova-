package com.fitnova.service;

import com.fitnova.model.entity.Notification;

import java.util.List;

public interface NotificationsService {
    List<Notification> getNotificationsByUserId(Integer userId);
    void markNotificationAsRead(Integer id);
    void createNotification(Notification notification);
    void deleteNotification(Integer id);
}


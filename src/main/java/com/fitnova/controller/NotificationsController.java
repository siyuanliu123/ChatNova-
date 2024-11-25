package com.fitnova.controller;

import com.fitnova.model.entity.Notification;
import com.fitnova.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {
    @Autowired
    private NotificationsService notificationsService;

    // 获取指定用户的通知列表
    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsByUserId(@PathVariable Integer userId) {
        return notificationsService.getNotificationsByUserId(userId);
    }

    // 标记某条通知为已读
    @PatchMapping("/{id}/read")
    public void markNotificationAsRead(@PathVariable Integer id) {
        notificationsService.markNotificationAsRead(id);
    }

    // 创建一条新通知
    @PostMapping
    public void createNotification(@RequestBody Notification notification) {
        notificationsService.createNotification(notification);
    }

    // 删除一条通知
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Integer id) {
        notificationsService.deleteNotification(id);
    }
}


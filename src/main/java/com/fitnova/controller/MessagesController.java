package com.fitnova.controller;

import com.fitnova.model.entity.Message;
import com.fitnova.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessagesController {
    @Autowired
    private MessagesService messagesService;

    // 获取指定用户的消息列表
    @GetMapping("/user/{userId}")
    public List<Message> getMessagesByUserId(@PathVariable Integer userId) {
        return messagesService.getMessagesByUserId(userId);
    }

    // 发送一条消息
    @PostMapping
    public void sendMessage(@RequestBody Message message) {
        messagesService.sendMessage(message);
    }

    // 删除一条消息
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Integer id) {
        messagesService.deleteMessage(id);
    }
}


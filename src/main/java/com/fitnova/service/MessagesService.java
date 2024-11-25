package com.fitnova.service;

import com.fitnova.model.entity.Message;

import java.util.List;

public interface MessagesService {
    List<Message> getMessagesByUserId(Integer userId);
    void sendMessage(Message message);
    void deleteMessage(Integer id);
}


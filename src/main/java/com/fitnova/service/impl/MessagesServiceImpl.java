package com.fitnova.service.impl;

import com.fitnova.mapper.MessagesMapper;
import com.fitnova.model.entity.Message;
import com.fitnova.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    private MessagesMapper messagesMapper;

    @Override
    public List<Message> getMessagesByUserId(Integer userId) {
        return messagesMapper.findByUserId(userId);
    }

    @Override
    public void sendMessage(Message message) {
        messagesMapper.insert(message);
    }

    @Override
    public void deleteMessage(Integer id) {
        messagesMapper.deleteById(id);
    }
}


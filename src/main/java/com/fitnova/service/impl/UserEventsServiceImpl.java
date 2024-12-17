package com.fitnova.service.impl;

import com.fitnova.mapper.UserEventsMapper;
import com.fitnova.model.entity.UserEvent;
import com.fitnova.service.UserEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEventsServiceImpl implements UserEventsService {

    @Autowired
    private UserEventsMapper userEventMapper;

    @Override
    public List<UserEvent> getAllEvents() {
        return userEventMapper.findAllEvents();
    }

    @Override
    public UserEvent getEventById(Integer eventId) {
        return userEventMapper.findEventById(eventId);
    }

    @Override
    public List<UserEvent> getEventsByCreator(Integer createdBy) {
        return userEventMapper.findEventsByCreator(createdBy);
    }

    @Override
    public int addEvent(UserEvent userEvent) {
        return userEventMapper.insertEvent(userEvent);
    }

    @Override
    public boolean updateEvent(UserEvent userEvent) {
        // 检查事件是否存在
        UserEvent existingEvent = userEventMapper.findEventById(userEvent.getEventId());
        if (existingEvent == null) {
            throw new IllegalStateException("Event not found");
        }
        // 执行更新操作
        int rowsAffected = userEventMapper.updateEvent(userEvent);
        return rowsAffected > 0;
    }


    @Override
    public void deleteEvent(Integer eventId) {
        UserEvent existingEvent = userEventMapper.findEventById(eventId);
        if (existingEvent == null) {
            throw new IllegalStateException("Event not found");
        }
        userEventMapper.deleteEvent(eventId);
    }
}

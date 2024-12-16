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
    public int updateEvent(UserEvent userEvent) {
        return userEventMapper.updateEvent(userEvent);
    }

    @Override
    public int deleteEvent(Integer eventId) {
        return userEventMapper.deleteEvent(eventId);
    }
}

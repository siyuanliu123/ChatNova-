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
    private UserEventsMapper userEventsMapper;

    @Override
    public int addEvent(UserEvent event) {
        return userEventsMapper.addEvent(event);
    }

    @Override
    public List<UserEvent> getEventsByUserId(Integer userId) {
        return userEventsMapper.findEventsByUserId(userId);
    }

    @Override
    public int updateEvent(UserEvent event) {
        return userEventsMapper.updateEvent(event);
    }

    @Override
    public int deleteEvent(Integer eventId) {
        return userEventsMapper.deleteEvent(eventId);
    }
}

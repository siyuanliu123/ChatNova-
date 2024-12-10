package com.fitnova.service;

import com.fitnova.model.entity.UserEvent;

import java.util.List;

public interface UserEventsService {
    int addEvent(UserEvent event);
    List<UserEvent> getEventsByUserId(Integer userId);
    int updateEvent(UserEvent event);
    int deleteEvent(Integer eventId);
}

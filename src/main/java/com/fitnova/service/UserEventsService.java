package com.fitnova.service;

import com.fitnova.model.entity.UserEvent;

import java.util.List;

public interface UserEventsService {
    List<UserEvent> getAllEvents();
    UserEvent getEventById(Integer eventId);
    List<UserEvent> getEventsByCreator(Integer createdBy);
    int addEvent(UserEvent userEvent);
    int updateEvent(UserEvent userEvent);
    int deleteEvent(Integer eventId);
}

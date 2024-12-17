package com.fitnova.service;

import com.fitnova.model.entity.UserEvent;

import java.util.List;

public interface UserEventsService {
    List<UserEvent> getAllEvents();
    UserEvent getEventById(Integer eventId);
    List<UserEvent> getEventsByCreator(Integer createdBy);
    int addEvent(UserEvent userEvent);
    boolean updateEvent(UserEvent userEvent);
    void deleteEvent(Integer eventId);

}

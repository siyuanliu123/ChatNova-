package com.fitnova.controller;

import com.fitnova.model.entity.UserEvent;
import com.fitnova.service.UserEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class UserEventsController {

    @Autowired
    private UserEventsService userEventsService;

    @PostMapping
    public String createEvent(@RequestBody UserEvent event) {
        userEventsService.addEvent(event);
        return "Event created successfully!";
    }

    @GetMapping("/user/{userId}")
    public List<UserEvent> getEventsByUserId(@PathVariable Integer userId) {
        return userEventsService.getEventsByUserId(userId);
    }

    @PutMapping("/{eventId}")
    public String updateEvent(@PathVariable Integer eventId, @RequestBody UserEvent event) {
        event.setEventId(eventId);
        userEventsService.updateEvent(event);
        return "Event updated successfully!";
    }

    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable Integer eventId) {
        userEventsService.deleteEvent(eventId);
        return "Event deleted successfully!";
    }
}

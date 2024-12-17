package com.fitnova.controller;

import com.fitnova.model.entity.UserEvent;
import com.fitnova.service.UserEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class UserEventsController {

    @Autowired
    private UserEventsService userEventsService;

    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable Integer eventId) {
        if (eventId == null || eventId <= 0) {
            return ResponseEntity.badRequest().body("Invalid event ID");
        }
        try {
            UserEvent event = userEventsService.getEventById(eventId);
            if (event == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
            }
            return ResponseEntity.ok(event);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the event");
        }
    }


    @PostMapping
    public ResponseEntity<String> createEvent(@RequestBody UserEvent event) {
        if (event.getTitle() == null || event.getTitle().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Title cannot be empty");
        }
        userEventsService.addEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event created successfully!");
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<String> updateEvent(@PathVariable Integer eventId, @RequestBody UserEvent event) {
        if (event.getTitle() == null || event.getTitle().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Title cannot be empty");
        }
        try {
            event.setEventId(eventId);
            userEventsService.updateEvent(event);
            return ResponseEntity.ok("Event updated successfully!");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Integer eventId) {
        try {
            userEventsService.deleteEvent(eventId);
            return ResponseEntity.noContent().build(); // 返回 204 No Content
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
    }
}


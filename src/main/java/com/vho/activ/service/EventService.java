package com.vho.activ.service;

import com.vho.activ.models.Event;
import com.vho.activ.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventRepo eventRepo;
    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public Event saveEvent(Event event) {
        return eventRepo.save(event);
    }
    public Event getEventById(long id) {
        return eventRepo.findById(id).get();
    }
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}

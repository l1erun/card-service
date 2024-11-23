package ru.cardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cardservice.entity.event.Event;
import ru.cardservice.repository.EventsRepository;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    public List<Event> getAllEventsCards() {
        return eventsRepository.findAll();
    }
}

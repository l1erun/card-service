package ru.cardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cardservice.entity.cards.Card;
import ru.cardservice.entity.events.Event;
import ru.cardservice.entity.locations.base.BaseLocation;
import ru.cardservice.entity.locations.forest.ForestLocation;
import ru.cardservice.service.CardService;
import ru.cardservice.service.EventsService;
import ru.cardservice.service.LocationBaseService;
import ru.cardservice.service.LocationForestService;

import java.util.List;

/**
 * Контроллер для управления картами.
 */
@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private LocationBaseService locationBaseService;
    @Autowired
    private LocationForestService locationForestService;
    @Autowired
    private EventsService eventsService;

    /**
     * Получает список всех карт.
     */
    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/baseLocations")
    public List<BaseLocation> getAllBaseLotions() {
        return locationBaseService.getAllLocations();
    }

    @GetMapping("/forestLocations")
    public List<ForestLocation> getAllForestLotions() {
        return locationForestService.getAllLocations();
    }

    @GetMapping("/events")
    public List<Event> getAllEventsCards() {
        return eventsService.getAllEventsCards();
    }
}

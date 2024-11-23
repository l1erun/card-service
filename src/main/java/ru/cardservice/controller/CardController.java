package ru.cardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cardservice.entity.baseGame.Card;
import ru.cardservice.entity.event.Event;
import ru.cardservice.entity.location.Location;
import ru.cardservice.service.CardService;
import ru.cardservice.service.EventsService;
import ru.cardservice.service.LocationCardService;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для управления картами.
 */
@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private LocationCardService locationCardService;
    @Autowired
    private EventsService eventsService;

    /**
     * Получает список всех карт.
     */
    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/locations")
    public List<Location> getAllLotionCards() {
        return locationCardService.getAllLocationCards();
    }

    @GetMapping("/events")
    public List<Event> getAllEventsCards() {
        return eventsService.getAllEventsCards();
    }

    /**
     * Получает карту по идентификатору.
     */
    @GetMapping("/{cardId}")
    public Card getCardById(@PathVariable UUID cardId) {
        return cardService.getCardById(cardId);
    }

    /**
     * Получает карты определенного дополнения.
     */
    @GetMapping("/expansion/{expansionName}")
    public List<Card> getCardsByExpansion(@PathVariable String expansionName) {
        return cardService.getCardsByExpansion(expansionName);
    }

    /**
     * Добавляет новую карту.
     */
    @PostMapping
    public Card addCard(@RequestBody Card card) {
        return cardService.addCard(card);
    }

    /**
     * Обновляет существующую карту.
     */
    @PutMapping("/{cardId}")
    public Card updateCard(@PathVariable UUID cardId, @RequestBody Card updatedCard) {
        return cardService.updateCard(cardId, updatedCard);
    }

    /**
     * Удаляет карту.
     */
    @DeleteMapping("/{cardId}")
    public void deleteCard(@PathVariable UUID cardId) {
        cardService.deleteCard(cardId);
    }
}

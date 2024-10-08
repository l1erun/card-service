package ru.cardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cardservice.entity.Card;
import ru.cardservice.repository.CardRepository;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для управления картами.
 */
@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    /**
     * Получает список всех карт.
     */
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    /**
     * Получает карту по идентификатору.
     */
    public Card getCardById(UUID cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));
    }

    /**
     * Получает карты определенного дополнения.
     */
    public List<Card> getCardsByExpansion(String expansion) {
        return cardRepository.findByExpansion(expansion);
    }

    /**
     * Добавляет новую карту.
     */
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    /**
     * Обновляет существующую карту.
     */
    public Card updateCard(UUID cardId, Card updatedCard) {
        Card existingCard = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));

        existingCard.setName(updatedCard.getName());
        existingCard.setType(updatedCard.getType());
        existingCard.setSubtype(updatedCard.getSubtype());
        existingCard.setCost(updatedCard.getCost());
        existingCard.setPoints(updatedCard.getPoints());
        existingCard.setExpansion(updatedCard.getExpansion());
        existingCard.setDescription(updatedCard.getDescription());
        existingCard.setImageUrl(updatedCard.getImageUrl());

        return cardRepository.save(existingCard);
    }

    /**
     * Удаляет карту.
     */
    public void deleteCard(UUID cardId) {
        cardRepository.deleteById(cardId);
    }
}

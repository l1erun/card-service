package ru.cardservice.loader.base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import ru.cardservice.entity.cards.Card;
import ru.cardservice.repository.CardRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardDataLoader {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    private final String[] files = {
            "classpath:cards/base/CONSTRUCTION.json",
            "classpath:cards/base/CREATURE.json"
    };

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        cardRepository.deleteAll();
        if (cardRepository.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();
            List<Card> allCards = new ArrayList<>();

            for (String filePath : files) {
                try {
                    Resource resource = resourceLoader.getResource(filePath);
                    List<Card> cards = mapper.readValue(resource.getInputStream(), new TypeReference<List<Card>>() {});
                    // Размножение карт на основе maxCount
                    for (Card card : cards) {
                        for (int i = 0; i < card.getMaxCount(); i++) {
                            Card cardCopy = new Card();
                            cardCopy.setName(card.getName());
                            cardCopy.setType(card.getType());
                            cardCopy.setCardType(card.getCardType());
                            cardCopy.setCost(card.getCost());
                            cardCopy.setPoints(card.getPoints());
                            cardCopy.setUniq(card.isUniq());
                            cardCopy.setPlacement(card.getPlacement());
                            cardCopy.setLinkedCritterDiscount(card.getLinkedCritterDiscount());
                            cardCopy.setMaxCount(1); // Устанавливаем maxCount в 1, чтобы не размножать уже размноженные карты
                            cardCopy.setExtension(card.getExtension());
                            cardCopy.setImageUrl(card.getImageUrl());
                            allCards.add(cardCopy);
                        }
                    }
                    allCards.addAll(cards);
                    System.out.println("Карты из файла " + filePath + " успешно загружены.");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Ошибка загрузки карт из файла " + filePath);
                }
            }

            // Сохраняем все карты в базу данных
            cardRepository.saveAll(allCards);
            System.out.println("Все карты успешно загружены в базу данных.");
        }
    }
}

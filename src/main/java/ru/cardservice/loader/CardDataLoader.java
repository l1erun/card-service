package ru.cardservice.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.cardservice.entity.baseGame.Card;
import ru.cardservice.repository.CardRepository;

@Component
public class CardDataLoader {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ResourceLoader resourceLoader; // Для динамической загрузки ресурсов

    private final String[] files = {
            "classpath:cards/baseGame/CONSTRUCTION.json",
            "classpath:cards/baseGame/CREATURE.json"
//            "classpath:cards/baseGame/EVENT.json"
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
                    List<Card> cards = mapper.readValue(resource.getInputStream(), new TypeReference<List<Card>>() {
                    });
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

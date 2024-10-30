package ru.cardservice.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import ru.cardservice.entity.baseGame.Card;
import ru.cardservice.entity.location.Location;
import ru.cardservice.repository.CardLocationRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardDataLocationLoader {
    @Autowired
    private CardLocationRepository cardLocationRepository;

    @Autowired
    private ResourceLoader resourceLoader; // Для динамической загрузки ресурсов

    private final String[] files = {
            "classpath:location/MAIN.json"
    };

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        cardLocationRepository.deleteAll();
        if (cardLocationRepository.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();
            List<Location> allCardsLocation = new ArrayList<>();

            for (String filePath : files) {
                try {
                    Resource resource = resourceLoader.getResource(filePath);
                    List<Location> cards = mapper.readValue(resource.getInputStream(), new TypeReference<List<Location>>() {
                    });
                    allCardsLocation.addAll(cards);
                    System.out.println("Карты из файла " + filePath + " успешно загружены.");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Ошибка загрузки карт из файла " + filePath);
                }
            }

            // Сохраняем все карты в базу данных
            cardLocationRepository.saveAll(allCardsLocation);
            System.out.println("Все карты успешно загружены в базу данных.");
        }
    }
}

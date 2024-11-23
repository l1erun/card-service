package ru.cardservice.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import ru.cardservice.entity.event.Event;
import ru.cardservice.repository.EventsRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventDataLoader {
    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private ResourceLoader resourceLoader; // Для динамической загрузки ресурсов

    private final String[] files = {
            "classpath:event/EVENT.json"
    };

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        eventsRepository.deleteAll();
        if (eventsRepository.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();
            List<Event> allCards = new ArrayList<>();

            for (String filePath : files) {
                try {
                    Resource resource = resourceLoader.getResource(filePath);
                    List<Event> events = mapper.readValue(resource.getInputStream(), new TypeReference<List<Event>>() {
                    });
                    allCards.addAll(events);
                    System.out.println("Карты из файла " + filePath + " успешно загружены.");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Ошибка загрузки карт из файла " + filePath);
                }
            }

            // Сохраняем все карты в базу данных
            eventsRepository.saveAll(allCards);
            System.out.println("Все карты успешно загружены в базу данных.");
        }
    }
}

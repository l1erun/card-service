package ru.cardservice.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import ru.cardservice.entity.Card;
import ru.cardservice.repository.CardRepository;

@Component
public class CardDataLoader {
    @Autowired
    private CardRepository cardRepository;

    @Value("classpath:cards.json")
    private Resource resourceFile;

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        cardRepository.deleteAll();
        if (cardRepository.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                List<Card> cards = mapper.readValue(resourceFile.getInputStream(), new TypeReference<List<Card>>() {});
                cardRepository.saveAll(cards);
                System.out.println("Карты успешно загружены в базу данных.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package ru.cardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cardservice.entity.location.Location;
import ru.cardservice.repository.CardLocationRepository;

import java.util.List;

@Service
public class LocationCardService {
    @Autowired
    private CardLocationRepository cardLocationRepository;

    public List<Location> getAllLocationCards() {
        return cardLocationRepository.findAll();
    }
}

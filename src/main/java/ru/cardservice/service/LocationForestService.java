package ru.cardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cardservice.entity.locations.forest.ForestLocation;
import ru.cardservice.repository.LocationForestRepository;

import java.util.List;

@Service
public class LocationForestService {
    @Autowired
    private LocationForestRepository locationForestRepository;

    public List<ForestLocation> getAllLocations() {
        return locationForestRepository.findAll();
    }
}

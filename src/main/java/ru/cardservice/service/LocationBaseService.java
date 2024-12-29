package ru.cardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cardservice.entity.locations.base.BaseLocation;
import ru.cardservice.repository.LocationBaseRepository;

import java.util.List;

@Service
public class LocationBaseService {
    @Autowired
    private LocationBaseRepository locationBaseRepository;

    public List<BaseLocation> getAllLocations() {
        return locationBaseRepository.findAll();
    }
}

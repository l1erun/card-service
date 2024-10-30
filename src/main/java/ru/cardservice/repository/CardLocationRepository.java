package ru.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cardservice.entity.location.Location;

import java.util.UUID;

@Repository
public interface CardLocationRepository extends JpaRepository<Location, UUID> {
}

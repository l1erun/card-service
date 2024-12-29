package ru.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cardservice.entity.locations.forest.ForestLocation;

import java.util.UUID;

@Repository
public interface LocationForestRepository extends JpaRepository<ForestLocation, UUID> {
}

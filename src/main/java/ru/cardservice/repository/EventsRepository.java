package ru.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cardservice.entity.event.Event;

import java.util.UUID;

@Repository
public interface EventsRepository extends JpaRepository<Event, UUID> {
}

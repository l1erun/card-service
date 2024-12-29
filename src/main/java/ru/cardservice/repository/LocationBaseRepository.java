package ru.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cardservice.entity.locations.base.BaseLocation;

import java.util.UUID;

@Repository
public interface LocationBaseRepository extends JpaRepository<BaseLocation, UUID> {
}

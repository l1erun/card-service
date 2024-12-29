package ru.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cardservice.entity.cards.Card;

import java.util.UUID;

/**
 * Репозиторий для работы с картами.
 */
@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

    // Другие необходимые методы
}

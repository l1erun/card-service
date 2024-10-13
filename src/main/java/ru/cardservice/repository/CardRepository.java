package ru.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cardservice.entity.baseGame.Card;

import java.util.List;
import java.util.UUID;

/**
 * Репозиторий для работы с картами.
 */
@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    List<Card> findByExpansion(String expansion);

    // Другие необходимые методы
}

package ru.cardservice.entity.cards;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Стоимость карты. Вложенная сущность.
 */
@Embeddable
@Data
public class Cost {
    private int twigs; // Ветки
    private int resin; // Смола
    private int pebbles; // Камни
    private int berries; // Ягоды
}

package ru.cardservice.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

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

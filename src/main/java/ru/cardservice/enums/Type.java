package ru.cardservice.enums;

import lombok.Getter;

/**
 * Перечисление типов карт.
 */
@Getter
public enum Type {
    CREATURE, // Существо
    CONSTRUCTION, // Строение
    EVENT, // Событие
    SPECIAL_EVENT, // Особое событие
    FOREST,
    LOCATION
}

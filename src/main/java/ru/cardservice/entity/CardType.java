package ru.cardservice.entity;

import lombok.Getter;

/**
 * Перечисление типов карт.
 */
@Getter
public enum CardType {
    CREATURE, // Существо
    CONSTRUCTION, // Строение
    EVENT, // Событие
    SPECIAL_EVENT // Особое событие
}

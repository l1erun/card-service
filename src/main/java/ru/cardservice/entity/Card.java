package ru.cardservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Карта игры. Хранится в базе данных.
 */
@Entity
@Table(name = "cards")
@Data
public class Card {
    @Id
    @GeneratedValue
    private UUID id; // Уникальный идентификатор карты

    @Column(nullable = false)
    private String name; // Название карты

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType type; // Тип карты (существо, здание и т.д.)

    private String subtype; // Подтип карты (если есть)

    @Embedded
    private Cost cost; // Стоимость карты

    private int points; // Количество очков

    private String expansion; // Название дополнения

    @Column(length = 1000)
    private String description; // Описание эффекта карты

    private String imageUrl; // Ссылка на изображение карты
}

package ru.cardservice.entity.cards;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import ru.cardservice.enums.Type;
import ru.cardservice.enums.ExtensionName;

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
    private Type type; // Тип карты (существо, здание и т.д.)

    @Column(nullable = false)
    @JsonProperty("card_type")
    private String cardType; // Тип карты (например, "зелёный", "фиолетовый")

    @Embedded
    private Cost cost; // Стоимость карты

    private int points; // Количество очков

    @JsonProperty("unique")
    private boolean uniq; // Уникальность карты

    @Embedded
    private Placement placement; // Свойства размещения работников

    @JsonProperty("linked_critter_discount")
    private String linkedCritterDiscount; // Связанный житель для скидки

    @JsonProperty("max_count")
    private int maxCount; // Максимальное количество таких карт в игре

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExtensionName extension; // Название дополнения

    @JsonProperty("image_url")
    private String imageUrl; // Ссылка на изображение карты
    private boolean locker;
}


package ru.cardservice.entity.locations;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class RewardsLocation {
    private int twigs; // Ветки
    private int resin; // Смола
    private int pebbles; // Камни
    private int berries; // Ягоды
    private int cards; // Карты
    private int points; // Очки
    @Column(name = "any_resource")
    private int any; // Любой ресурс
}

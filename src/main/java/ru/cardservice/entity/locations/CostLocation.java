package ru.cardservice.entity.locations;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CostLocation {
    @Column(name = "twigs_cost")
    private int twigs; // Ветки
    @Column(name = "resin_cost")
    private int resin; // Смола
    @Column(name = "pebbles_cost")
    private int pebbles; // Камни
    @Column(name = "berries_cost")
    private int berries; // Ягоды
    @Column(name = "cards_cost")
    private int cards; // Карты
    @Column(name = "points_cost")
    private int points; // Очки
}

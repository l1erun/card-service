package ru.cardservice.entity.location;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CostLocation {
    private int twigs;
    private int resin;
    private int pebbles;
    private int berries;
    private int points;
    private int cards;
}

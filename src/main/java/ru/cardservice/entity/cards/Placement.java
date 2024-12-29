package ru.cardservice.entity.cards;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Placement {
    private int capacity; // Количество работников, которых можно разместить
    @JsonProperty("allowed_workers")
    private String allowedWorkers; // Кто может размещать работников ("any", "user" или null)
}


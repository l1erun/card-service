package ru.cardservice.entity.locations.forest;

import jakarta.persistence.*;
import lombok.Data;
import ru.cardservice.entity.locations.CostLocation;
import ru.cardservice.entity.locations.RewardsLocation;
import ru.cardservice.enums.ExtensionName;
import ru.cardservice.enums.Type;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "forest_locations")
@Data
public class ForestLocation implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExtensionName extension; // Название дополнения

    @Embedded
    @Column(nullable = false)
    private RewardsLocation rewards; // Награды за использование локации

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CostLocation cost;


    @Column(name = "worker_slots", nullable = false)
    private int workerSlots; // Количество доступных слотов для рабочих

    @Column(nullable = false)
    private boolean uniq; // Уникальность локации (true/false)

    @Column(length = 1000)
    private String description; // Описание локации

    @Column(name = "image_url")
    private String imageUrl; // Ссылка на изображение
}

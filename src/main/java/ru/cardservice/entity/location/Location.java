package ru.cardservice.entity.location;

import jakarta.persistence.*;
import lombok.Data;
import ru.cardservice.entity.ExtensionName;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "location_cards")
@Data
public class Location implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExtensionName expansion;

    @Column(nullable = false)
    private String effect;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CostLocation cost;

    @Column(nullable = false)
    private String workerLimit;
}

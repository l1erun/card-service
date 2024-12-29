package ru.cardservice.entity.events;

import jakarta.persistence.*;
import lombok.Data;
import ru.cardservice.enums.ExtensionName;

import java.util.UUID;

@Entity
@Table(name = "events")
@Data
public class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String type;
    private String subtype;
    private String points;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExtensionName extension; // Название дополнения
    private String description;
    private String imageUrl;
}

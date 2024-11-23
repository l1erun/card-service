package ru.cardservice.entity.event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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
    private String expansion;
    private String description;
    private String imageUrl;
}

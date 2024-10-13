package ru.cardservice.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum ExtensionName {
    BASE_GAME("Base Game"),
    spirecrest("Spirecrest");

    private final String displayName;

    ExtensionName(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static ExtensionName fromString(String value) {
        for (ExtensionName extension : ExtensionName.values()) {
            if (extension.displayName.equalsIgnoreCase(value)) {
                return extension;
            }
        }
        throw new IllegalArgumentException("Unknown expansion: " + value);
    }
}

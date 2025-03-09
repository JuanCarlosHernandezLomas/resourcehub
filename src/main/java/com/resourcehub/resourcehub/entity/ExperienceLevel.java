package com.resourcehub.resourcehub.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum ExperienceLevel {
    JUNIOR("Junior"),
    MID("Mid"),
    SENIOR("Senior");

    private final String value;
    ExperienceLevel(String value){
        this.value=value;
    }
    @JsonValue
    public String getValue() {
        return value;
    }
    @JsonCreator
    public static ExperienceLevel fromString(String status) {
        return Stream.of(ExperienceLevel.values())
                .filter(e -> e.value.equalsIgnoreCase(status) || e.name().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Estado de disponibilidad no válido: " + status));
    }
}

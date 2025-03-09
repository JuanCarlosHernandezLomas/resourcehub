package com.resourcehub.resourcehub.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum AvailabilityStatus {
    BENCH("Bench"),
    ALLOCATED("Allocated"),
    UNAVAILABLE("Unavailable");

    private final String value;

    AvailabilityStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static AvailabilityStatus fromString(String status) {
        return Stream.of(AvailabilityStatus.values())
                .filter(e -> e.value.equalsIgnoreCase(status) || e.name().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Estado de disponibilidad no válido: " + status));
    }
}


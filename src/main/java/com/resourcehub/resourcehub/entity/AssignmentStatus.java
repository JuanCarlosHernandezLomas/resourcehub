package com.resourcehub.resourcehub.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum AssignmentStatus {
    ACTIVE("Atcive"),
    COMPLETED("Completed"),
    PENDING("Pending");

    private final String value;

    AssignmentStatus(String value){
        this.value= value;
    }
    @JsonValue
    public String getValue() {
        return value;
}
    @JsonCreator
    public static AssignmentStatus fromString(String status) {
        return Stream.of(AssignmentStatus.values())
                .filter(e -> e.value.equalsIgnoreCase(status) || e.name().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Estado de disponibilidad no válido: " + status));
    }
}

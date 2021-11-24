package model;

import java.util.List;

public enum Type {
    SELL, BUY;

    public static Type fromString(String type) {
        return List.of(values()).stream()
                .filter(value -> value.toString().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to find Type matching: " + type));
    }
}

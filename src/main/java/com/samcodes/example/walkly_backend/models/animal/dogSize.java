package com.samcodes.example.walkly_backend.models.animal;

public enum dogSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String value;

    dogSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package com.enums;

public enum Designation {
    ASSISTANT_PROFESSOR("Assistant Professor"),
    ASSOCIATE_PROFESSOR("Associate Professor"),
    PROFESSOR("Professor"),
    HOD("Head of Department"),
    GUEST_FACULTY("Guest Faculty");

    private final String displayName;

    Designation(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

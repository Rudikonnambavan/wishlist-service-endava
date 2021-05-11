package com.endava.wishlistservice.persistence.entity;

public enum EventType {
    WEDDING, BIRTHDAY, OTHER;

    public static boolean contains(String value) {
        for (EventType et : EventType.values())
            if (et.name().equals(value)) {
                return true;
            }
        return false;
    }

    public static boolean notContains(String value) {
        return !contains(value);
    }
}

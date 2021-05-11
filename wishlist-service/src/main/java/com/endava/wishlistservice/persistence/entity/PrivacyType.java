package com.endava.wishlistservice.persistence.entity;

public enum PrivacyType {
    PRIVATE, PUBLIC;

    public static boolean contains(String value) {
        for (PrivacyType pt : PrivacyType.values())
            if (pt.name().equals(value)) {
                return true;
            }
        return false;
    }

    public static boolean notContains(String value) {
        return !contains(value);
    }
}

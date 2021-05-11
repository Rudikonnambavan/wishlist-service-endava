package com.endava.wishlistservice.exception;

import lombok.Getter;

@Getter
public class InvalidValueException extends RuntimeException {

    private final String field;

    private final String value;

    public InvalidValueException(String field, String value) {
        super("Invalid value: " + value + " for field: " + field);
        this.field = field;
        this.value = value;
    }
}

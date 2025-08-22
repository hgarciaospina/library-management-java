package com.jikkosoft.library.domain.vo;

/**
 * Value Object representing an email address.
 * Ensures proper email format and immutability.
 */
public final class Email {

    private final String value;

    public Email(String value) {
        if (!value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.value = value;
    }

    public String getValue() { return value; }
}

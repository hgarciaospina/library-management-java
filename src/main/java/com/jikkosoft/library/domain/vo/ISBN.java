package com.jikkosoft.library.domain.vo;

/**
 * Value Object representing a book ISBN.
 * Ensures that ISBN is valid and immutable.
 */
public final class ISBN {

    private final String value;

    public ISBN(String value) {
        if (!value.matches("\\d{10}|\\d{13}")) {
            throw new IllegalArgumentException("ISBN must be 10 or 13 digits");
        }
        this.value = value;
    }

    public String getValue() { return value; }
}

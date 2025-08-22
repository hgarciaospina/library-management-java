package com.jikkosoft.library.domain.vo;

/**
 * Value Object representing a book title.
 * Ensures non-empty and immutable title.
 */
public final class BookTitle {

    private final String value;

    public BookTitle(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        this.value = value;
    }

    public String getValue() { return value; }
}

package com.jikkosoft.library.domain.vo;

import java.util.Objects;

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
        this.value = value.trim();
    }

    public String getValue() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookTitle)) return false;
        BookTitle that = (BookTitle) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

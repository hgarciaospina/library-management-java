package com.jikkosoft.library.domain.vo;

import java.util.Objects;

/**
 * Value Object representing an ISBN (International Standard Book Number).
 *
 * Responsibilities:
 * - Encapsulates the ISBN as a domain concept.
 * - Validates format depending on publication year:
 *   - ISBN-10 for books published before 2007
 *   - ISBN-13 for books published from 2007 onwards
 * - Immutable after creation.
 *
 * Invariants:
 * - ISBN must not be null or blank.
 * - ISBN length must match the expected format based on publication year.
 *
 * Example usage:
 *   ISBN isbn = new ISBN("1234567890", 2005); // ISBN-10
 *   ISBN isbn2 = new ISBN("9781234567897", 2010); // ISBN-13
 */
public final class ISBN {

    private final String value;

    /**
     * Constructs an ISBN value object with validation based on publication year.
     *
     * @param value           the raw ISBN string
     * @param publicationYear the year the book was published
     * @throws IllegalArgumentException if the value is null, blank, or does not match expected format
     */
    public ISBN(String value, int publicationYear) {
        validate(value, publicationYear);
        this.value = value;
    }

    private void validate(String value, int publicationYear) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be null or blank.");
        }
        if (publicationYear < 2007 && value.length() != 10) {
            throw new IllegalArgumentException("ISBN-10 required for publications before 2007.");
        }
        if (publicationYear >= 2007 && value.length() != 13) {
            throw new IllegalArgumentException("ISBN-13 required for publications from 2007 onwards.");
        }
    }

    /**
     * Returns the ISBN string value.
     *
     * @return the ISBN value
     */
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ISBN)) return false;
        ISBN isbn = (ISBN) o;
        return Objects.equals(value, isbn.value);
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

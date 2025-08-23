package com.jikkosoft.library.domain.vo;

/**
 * Value Object representing an ISBN (International Standard Book Number).
 * Provides validation for ISBN-10 and ISBN-13 depending on publication year.
 *
 * Validation responsibilities:
 * - ISBN must not be null or blank.
 * - If publication year < 2007 → ISBN-10 expected.
 * - If publication year >= 2007 → ISBN-13 expected.
 */
public class ISBN {

    private final String value;

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

    public String getValue() {
        return value;
    }

    @Override
    public String toString() { return value; }
}

package com.jikkosoft.library.domain.vo;

import java.util.Objects;

/**
 * Value Object representing an email address for a system user or member.
 *
 * Responsibilities:
 * - Encapsulates the email as a domain concept.
 * - Ensures immutability and proper formatting.
 * - Provides consistent equality and hash code behavior.
 *
 * Invariants:
 * - Must not be null.
 * - Must match a simple email regex pattern.
 * - Always stored as lowercase and trimmed.
 *
 * Example usage:
 *   Email userEmail = new Email("John.Doe@example.com");
 *   System.out.println(userEmail.getValue()); // prints "john.doe@example.com"
 *
 * Notes:
 * - Equality is based on normalized email value.
 * - This VO can be safely used as a key in collections or maps.
 */
public final class Email {

    private static final String SIMPLE_EMAIL_REGEX =
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private final String value;

    /**
     * Constructs an Email value object with normalization and validation.
     *
     * @param raw the raw email string
     * @throws IllegalArgumentException if null or invalid format
     */
    public Email(String raw) {
        if (raw == null) throw new IllegalArgumentException("Email must not be null");
        String normalized = raw.trim().toLowerCase();
        if (!normalized.matches(SIMPLE_EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.value = normalized;
    }

    /**
     * Returns the normalized email string.
     *
     * @return the email value
     */
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return value.equals(email.value);
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

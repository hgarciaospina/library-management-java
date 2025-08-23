package com.jikkosoft.library.domain.vo;

/**
 * Value Object representing the number of penalty days for overdue books.
 *
 * Invariants:
 * - Must be a non-negative integer (>= 0).
 * - Immutable.
 * - Always exists; cannot be null.
 *
 * Usage:
 * - Encapsulates the concept of overdue penalty days within the domain.
 * - Prevents invalid negative values and clarifies intent at compile time.
 */
public final class PenaltyDays {

    private final int value;

    /**
     * Constructs a PenaltyDays value object.
     *
     * @param value the number of penalty days, must be >= 0
     * @throws IllegalArgumentException if value is negative
     */
    public PenaltyDays(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Penalty days cannot be negative");
        }
        this.value = value;
    }

    /**
     * Returns the number of penalty days.
     *
     * @return non-negative integer value of penalty days
     */
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PenaltyDays)) return false;
        PenaltyDays that = (PenaltyDays) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

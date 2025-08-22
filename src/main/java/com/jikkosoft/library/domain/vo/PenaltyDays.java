package com.jikkosoft.library.domain.vo;

/**
 * Value Object representing penalty days for overdue books.
 * Ensures non-negative integer and immutability.
 */
public final class PenaltyDays {

    private final int value;

    public PenaltyDays(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Penalty days cannot be negative");
        }
        this.value = value;
    }

    public int getValue() { return value; }
}

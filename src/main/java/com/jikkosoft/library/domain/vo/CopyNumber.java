package com.jikkosoft.library.domain.vo;

import java.util.Objects;

/**
 * Value Object representing the sequential copy number for a book within a library.
 *
 * Invariants:
 * - Must be >= 1.
 * - Immutable.
 */
public final class CopyNumber {

    private final int number;

    public CopyNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Copy number must be >= 1");
        }
        this.number = number;
    }

    public int getNumber() { return number; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CopyNumber)) return false;
        CopyNumber that = (CopyNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

package com.jikkosoft.library.domain.vo;

import java.util.Objects;

/**
 * Value Object representing the sequential copy number of a specific Book within a Library.
 *
 * Responsibilities:
 * - Uniquely identifies a physical copy of a book among all copies of the same book in a library.
 * - Encapsulates the sequential numbering as a domain concept.
 *
 * Invariants:
 * - Copy number must be >= 1.
 * - Immutable once created.
 *
 * Notes on variants:
 * - Different editions, formats (paperback, hardcover), or versions of a book
 *   may have their own independent copy numbering in the same library.
 * - This VO represents the sequence within a single edition/format of a book.
 *
 * Example usage:
 *   CopyNumber firstCopy = new CopyNumber(1);
 *   CopyNumber secondCopy = new CopyNumber(2);
 *
 * Equality and hash code are based on the numeric value.
 */
public final class CopyNumber {

    private final int number;

    /**
     * Constructs a CopyNumber value object with a given sequential number.
     *
     * @param number Sequential number of the copy (must be >= 1)
     * @throws IllegalArgumentException if number < 1
     */
    public CopyNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Copy number must be >= 1");
        }
        this.number = number;
    }

    /**
     * Returns the numeric value of this copy number.
     *
     * @return the sequential copy number as an int
     */
    public int getNumber() {
        return number;
    }

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

package com.jikkosoft.library.domain.vo;

/**
 * Value Object representing the copy number of a book.
 * Ensures positive integer and immutability.
 */
public final class CopyNumber {

    private final int value;

    public CopyNumber(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Copy number must be positive");
        }
        this.value = value;
    }

    public int getValue() { return value; }
}

package com.jikkosoft.library.domain.model;

import java.util.Objects;

/**
 * Domain model representing a Book Category.
 *
 * A Category defines the business constraints and rules for books,
 * such as:
 * - Maximum number of loan days allowed for books in this category.
 * - Monetary penalty applied for each overdue day.
 *
 * Invariants enforced:
 * - Name must not be null or blank.
 * - maxLoanDays must be > 0.
 * - penaltyPerDay must be >= 0.
 */
public class Category {

    private final Long id;
    private final String name;
    private final int maxLoanDays;
    private final int penaltyPerDay;

    /**
     * Constructs a Category with validation of core invariants.
     *
     * @param id             optional domain identifier (nullable for transient instances).
     * @param name           category name (must not be null or blank).
     * @param maxLoanDays    maximum number of days a book can be loaned (must be > 0).
     * @param penaltyPerDay  monetary penalty per overdue day (must be >= 0).
     * @throws IllegalArgumentException if any invariant is violated.
     */
    public Category(Long id, String name, int maxLoanDays, int penaltyPerDay) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be null or blank");
        }
        if (maxLoanDays <= 0) {
            throw new IllegalArgumentException("Category maxLoanDays must be greater than zero");
        }
        if (penaltyPerDay < 0) {
            throw new IllegalArgumentException("Category penaltyPerDay cannot be negative");
        }
        this.id = id;
        this.name = name.trim();
        this.maxLoanDays = maxLoanDays;
        this.penaltyPerDay = penaltyPerDay;
    }

    /** @return domain identifier (nullable if transient). */
    public Long getId() { return id; }

    /** @return the business name of the category. */
    public String getName() { return name; }

    /** @return maximum number of days allowed for a loan. */
    public int getMaxLoanDays() { return maxLoanDays; }

    /** @return penalty applied for each overdue day. */
    public int getPenaltyPerDay() { return penaltyPerDay; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        // Equality by name (business key). Adapt if you prefer ID-based equality later.
        return name.equalsIgnoreCase(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxLoanDays=" + maxLoanDays +
                ", penaltyPerDay=" + penaltyPerDay +
                '}';
    }
}

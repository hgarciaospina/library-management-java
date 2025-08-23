package com.jikkosoft.library.domain.model;

import java.util.Objects;

/**
 * Domain model representing a Book Category.
 *
 * Responsibilities:
 * - Defines rules and constraints for books, e.g., max loan days and penalties.
 * - Ensures invariants for all fields at construction time.
 * - Integrates with audit tracking via BaseEntity.
 *
 * Invariants enforced:
 * - Name must not be null or blank.
 * - maxLoanDays must be greater than 0.
 * - penaltyPerDay must be >= 0.
 *
 * Notes:
 * - Builder pattern used for safe and clear construction.
 * - All fields are immutable after creation.
 */
public class Category extends BaseEntity {

    private final Long id;
    private final String name;
    private final int maxLoanDays;
    private final int penaltyPerDay;

    // ======================= Private constructor =======================
    private Category(Builder builder) {
        super();
        if (builder.name == null || builder.name.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be null or blank");
        }
        if (builder.maxLoanDays <= 0) {
            throw new IllegalArgumentException("Category maxLoanDays must be greater than zero");
        }
        if (builder.penaltyPerDay < 0) {
            throw new IllegalArgumentException("Category penaltyPerDay cannot be negative");
        }

        this.id = builder.id;
        this.name = builder.name.trim();
        this.maxLoanDays = builder.maxLoanDays;
        this.penaltyPerDay = builder.penaltyPerDay;
    }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private String name;
        private int maxLoanDays;
        private int penaltyPerDay;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder maxLoanDays(int days) { this.maxLoanDays = days; return this; }
        public Builder penaltyPerDay(int penalty) { this.penaltyPerDay = penalty; return this; }

        public Category build() { return new Category(this); }
    }

    // ======================= Getters =======================
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getMaxLoanDays() { return maxLoanDays; }
    public int getPenaltyPerDay() { return penaltyPerDay; }

    // ======================= Equality & Debug =======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
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
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }
}

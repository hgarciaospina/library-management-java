package com.jikkosoft.library.domain.model;

/**
 * Represents a book category.
 * Each category defines maximum loan days and penalty per overdue day.
 */
public class Category {

    private final Long id;
    private final String name;
    private final int maxLoanDays;
    private final int penaltyPerDay;

    public Category(Long id, String name, int maxLoanDays, int penaltyPerDay) {
        this.id = id;
        this.name = name;
        this.maxLoanDays = maxLoanDays;
        this.penaltyPerDay = penaltyPerDay;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getMaxLoanDays() { return maxLoanDays; }
    public int getPenaltyPerDay() { return penaltyPerDay; }
}

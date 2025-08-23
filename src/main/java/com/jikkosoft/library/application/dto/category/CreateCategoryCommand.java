package com.jikkosoft.library.application.dto.category;

/**
 * Command to create a new Category.
 */
public record CreateCategoryCommand(
        String name,
        int maxLoanDays,
        int penaltyPerDay
) {}

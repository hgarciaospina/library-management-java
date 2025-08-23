package com.jikkosoft.library.application.dto.category;

/**
 * Command to update a Category.
 */
public record UpdateCategoryCommand(
        Long categoryId,
        String name,
        Integer maxLoanDays,
        Integer penaltyPerDay
) {}

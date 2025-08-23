package com.jikkosoft.library.application.dto.category;

/**
 * Read model for category data.
 */
public record CategoryResponse(
        Long id,
        String name,
        int maxLoanDays,
        int penaltyPerDay
) {}

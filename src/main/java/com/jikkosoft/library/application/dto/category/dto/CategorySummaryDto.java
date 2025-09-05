package com.jikkosoft.library.application.dto.category.dto;

/**
 * Summary Data Transfer Object for Book Category.
 *
 * Responsibilities:
 * - Provides a condensed but useful view of a Book Category.
 * - Ideal for listings, dropdowns, and quick associations.
 * - Does not include audit fields.
 */
public record CategorySummaryDto(

        /** Unique identifier of the category. */
        Long id,

        /** Name of the category (e.g., Fiction, Science). */
        String name,

        /** Maximum number of days a book in this category can be loaned. */
        int maxLoanDays,

        /** Penalty per day for overdue books in this category. */
        int penaltyPerDay

) {}

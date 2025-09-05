package com.jikkosoft.library.application.dto.category;

/**
 * Data Transfer Object representing a Book Category for read operations.
 *
 * Responsibilities:
 * - Provides a safe, read-only view of a Book Category.
 * - Immutable structure using Java record.
 * - Exposes essential fields for display or reporting purposes.
 */
public record CategoryDto(

        /** Unique identifier of the category. */
        Long id,

        /** Name of the category (e.g., Fiction, Science). */
        String name,

        /** Maximum number of days a book in this category can be loaned. */
        int maxLoanDays,

        /** Penalty per day for overdue books in this category. */
        int penaltyPerDay

) {}

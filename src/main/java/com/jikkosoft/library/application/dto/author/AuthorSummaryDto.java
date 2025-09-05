package com.jikkosoft.library.application.dto.author;

import java.time.LocalDate;

/**
 * Summary Data Transfer Object (DTO) for Author.
 *
 * Responsibilities:
 * - Provides a condensed but useful view of an Author.
 * - Ideal for listings, dropdowns, and book associations.
 * - Exposes contextual information without audit fields.
 *
 * Notes:
 * - {@code fullName} is typically derived from firstName + lastName.
 * - {@code bookCount} represents the total number of authored books (aggregate info).
 */
public record AuthorSummaryDto(
        Long id,
        String fullName,
        String nationality,
        LocalDate dateOfBirth,
        String email,
        String affiliation,
        String website,
        int bookCount
) {}

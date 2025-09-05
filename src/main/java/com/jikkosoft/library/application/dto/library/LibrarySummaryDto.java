package com.jikkosoft.library.application.dto.library;

/**
 * Summary Data Transfer Object for Library.
 *
 * Responsibilities:
 * - Provides a condensed and immutable representation of a Library.
 * - Excludes members and book copies to optimize performance.
 * - Ideal for list views, dropdowns, or queries where full details are not required.
 */
public record LibrarySummaryDto(

        /** Unique identifier of the library. */
        Long id,

        /** Name of the library. */
        String name,

        /** Physical address of the library. */
        String address
) {}

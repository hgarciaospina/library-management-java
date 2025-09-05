package com.jikkosoft.library.application.dto.bookcopy.dto;

/**
 * Summary Data Transfer Object for BookCopy.
 *
 * Responsibilities:
 * - Provides a condensed but useful view of a BookCopy.
 * - Balances relational IDs (for system use) with human-readable names.
 * - Ideal for listings, availability checks, and quick associations.
 * - Exposes more context than a minimal DTO, without audit fields.
 */
public record BookCopySummaryDto(

        /** Unique identifier of the BookCopy. */
        Long id,

        /** Unique barcode identifier for physical tracking. */
        String barcode,

        /**
         * Current availability status of the copy.
         * Possible values: AVAILABLE, LOANED, RESERVED, LOST, DAMAGED.
         */
        String status,

        /** Physical shelf location inside the library. */
        String shelfLocation,

        /** Sequential number of the copy, unique within the same book and library. */
        Integer copyNumber,

        // --- Book association ---

        /** Identifier of the associated Book. */
        Long bookId,

        /** Title of the associated Book. */
        String bookTitle,

        /** ISBN of the associated Book. */
        String isbn,

        // --- Library association ---

        /** Identifier of the associated Library. */
        Long libraryId,

        /** Name of the associated Library. */
        String libraryName
) {}

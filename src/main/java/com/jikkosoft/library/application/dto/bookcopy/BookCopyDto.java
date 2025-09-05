package com.jikkosoft.library.application.dto.bookcopy;

import java.time.LocalDateTime;

/**
 * Data Transfer Object representing a full BookCopy entity.
 *
 * Responsibilities:
 * - Provides complete information about a specific physical copy of a book.
 * - Includes enriched data for display (book title, library name).
 * - Contains audit fields inherited from BaseEntity.
 * - Immutable structure using Java record.
 */
public record BookCopyDto(
        Long id,

        /** Identifier of the related book. */
        Long bookId,

        /** Title of the related book (for display purposes). */
        String bookTitle,

        /** Identifier of the library holding this copy. */
        Long libraryId,

        /** Name of the library (for display purposes). */
        String libraryName,

        /** Sequential number of the copy, unique within the same book and library. */
        Integer copyNumber,

        /** Unique barcode identifier for physical tracking. */
        String barcode,

        /**
         * Current status of the copy.
         * Possible values: AVAILABLE, LOANED, RESERVED, DAMAGED.
         */
        String status,

        /** Physical shelf location of the copy in the library. */
        String shelfLocation,

        /** Audit field: creation timestamp. */
        LocalDateTime createdAt,

        /** Audit field: last update timestamp. */
        LocalDateTime updatedAt,

        /** Audit field: logical deletion timestamp. */
        LocalDateTime deletedAt
) {}

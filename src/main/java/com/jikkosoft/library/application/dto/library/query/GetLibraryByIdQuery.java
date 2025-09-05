package com.jikkosoft.library.application.dto.library.query;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a Library by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the Library to be retrieved.
 * - Can return the full LibraryDto (including members and book copies) if needed.
 * - Immutable structure provided by Java record.
 */
public record GetLibraryByIdQuery(

        /** Identifier of the Library (required). */
        @NotNull(message = "Library ID is required")
        Long id

) {}

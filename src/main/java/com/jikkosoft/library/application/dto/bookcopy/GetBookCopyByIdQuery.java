package com.jikkosoft.library.application.dto.bookcopy;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a BookCopy by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the BookCopy to be retrieved.
 * - Enforces validation at the boundary level using {@link NotNull}.
 * - Immutable structure provided by Java record.
 */
public record GetBookCopyByIdQuery(

        /** Identifier of the BookCopy (required). */
        @NotNull(message = "BookCopy ID is required")
        Long id

) {}

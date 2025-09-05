package com.jikkosoft.library.application.dto.book.query;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a Book by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the book to be retrieved.
 * - Enforces validation at the boundary level using {@link NotNull}.
 * - Immutable structure provided by Java record.
 */
public record GetBookByIdQuery(
        @NotNull(message = "Book ID is required")
        @NotNull Long id
) {}

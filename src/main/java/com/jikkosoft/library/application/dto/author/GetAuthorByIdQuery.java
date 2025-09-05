package com.jikkosoft.library.application.query.author;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve an Author by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the author to be retrieved.
 * - Ensures the identifier is provided and valid.
 */
public record GetAuthorByIdQuery(
        @NotNull(message = "Author ID is required")
        Long id
) {}

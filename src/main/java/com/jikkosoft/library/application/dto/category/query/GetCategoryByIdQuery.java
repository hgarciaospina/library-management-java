package com.jikkosoft.library.application.dto.category.query;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a Book Category by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the category to be retrieved.
 * - Enforces validation at the boundary level using {@link NotNull}.
 * - Immutable structure provided by Java record.
 */
public record GetCategoryByIdQuery(

        /** Identifier of the category (required). */
        @NotNull(message = "Category ID is required")
        Long id

) {}

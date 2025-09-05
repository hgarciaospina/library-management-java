package com.jikkosoft.library.application.dto.user.query;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a User by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the User to retrieve.
 * - Immutable structure using Java record.
 */
public record GetUserByIdQuery(

        /** Identifier of the user (required). */
        @NotNull(message = "User ID is required")
        Long id

) {}

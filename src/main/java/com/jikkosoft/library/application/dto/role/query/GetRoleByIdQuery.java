package com.jikkosoft.library.application.dto.role.query;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a Role by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the role to retrieve.
 * - Immutable using Java record.
 */
public record GetRoleByIdQuery(

        /** Identifier of the role (required). */
        @NotNull(message = "Role ID is required")
        Long id

) {}

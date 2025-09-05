package com.jikkosoft.library.application.dto.member;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a Member by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the Member to retrieve.
 * - Immutable structure using Java record.
 */
public record GetMemberByIdQuery(

        /** Identifier of the member (required). */
        @NotNull(message = "Member ID is required")
        Long id

) {}

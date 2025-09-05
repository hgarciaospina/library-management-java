package com.jikkosoft.library.application.dto.user.dto;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Full Data Transfer Object for User.
 *
 * Responsibilities:
 * - Provides a complete and immutable representation of a User entity.
 * - Includes roles and audit metadata (createdAt, updatedAt, deletedAt).
 * - Designed for safe API exposure.
 */
public record UserDto(

        /** Unique identifier of the user. */
        Long id,

        /** Email address of the user. */
        String email,

        /** Set of role names assigned to the user. */
        Set<String> roles,

        /** Indicates whether the user is active. */
        boolean active,

        /** Timestamp when the user was created. */
        LocalDateTime createdAt,

        /** Timestamp when the user was last updated. */
        LocalDateTime updatedAt,

        /** Timestamp when the user was logically deleted (if applicable). */
        LocalDateTime deletedAt
) {}

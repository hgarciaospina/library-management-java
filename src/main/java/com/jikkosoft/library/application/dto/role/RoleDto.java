package com.jikkosoft.library.application.dto.role;

import com.jikkosoft.library.domain.enums.RoleType;
import java.time.LocalDateTime;

/**
 * Full Data Transfer Object for Role.
 *
 * Responsibilities:
 * - Represents a Role entity in full detail.
 * - Includes type, description, and audit fields.
 * - Immutable and safe for API exposure.
 */
public record RoleDto(

        /** Unique identifier of the role. */
        Long id,

        /** Role type (NORMAL_USER, ADMIN, SUPER_USER). */
        RoleType roleType,

        /** Optional description for the role. */
        String description,

        /** Timestamp when the role was created. */
        LocalDateTime createdAt,

        /** Timestamp when the role was last updated. */
        LocalDateTime updatedAt,

        /** Timestamp when the role was logically deleted. */
        LocalDateTime deletedAt
) {}

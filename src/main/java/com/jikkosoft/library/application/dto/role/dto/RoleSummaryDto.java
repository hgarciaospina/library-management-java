package com.jikkosoft.library.application.dto.role.dto;

import com.jikkosoft.library.domain.enums.RoleType;

/**
 * Condensed Data Transfer Object for Role.
 *
 * Responsibilities:
 * - Provides a lightweight view of a Role.
 * - Ideal for lists, dropdowns, or queries where full audit details are not required.
 * - Immutable and safe for API exposure.
 */
public record RoleSummaryDto(

        /** Unique identifier of the role. */
        Long id,

        /** Role type (NORMAL_USER, ADMIN, SUPER_USER). */
        RoleType roleType

) {}

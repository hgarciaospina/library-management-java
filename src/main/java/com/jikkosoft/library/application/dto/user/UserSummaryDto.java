package com.jikkosoft.library.application.dto.user;

import java.util.Set;

/**
 * Summary Data Transfer Object for User.
 *
 * Responsibilities:
 * - Provides a condensed view of a User for listings.
 * - Excludes audit fields.
 */
public record UserSummaryDto(

        /** Unique identifier of the user. */
        Long id,

        /** Email address of the user. */
        String email,

        /** Set of role names assigned to the user. */
        Set<String> roles,

        /** Indicates whether the user is active. */
        boolean active
) {}

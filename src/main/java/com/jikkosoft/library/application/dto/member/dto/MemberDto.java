package com.jikkosoft.library.application.dto.member.dto;

import java.time.LocalDateTime;

/**
 * Full Data Transfer Object for Member.
 *
 * Responsibilities:
 * - Provides a complete and immutable representation of a Member entity.
 * - Includes audit metadata (createdAt, updatedAt, deletedAt).
 * - Safe for API exposure.
 */
public record MemberDto(

        /** Unique identifier of the member. */
        Long id,

        /** Identifier of the associated User account. */
        Long userId,

        /** Identifier of the associated Library. */
        Long libraryId,

        /** First name of the member. */
        String firstName,

        /** Last name of the member. */
        String lastName,

        /** Email address of the member. */
        String email,

        /** Status of the member (active/inactive). */
        boolean active,

        /** Total penalty days accumulated by the member. */
        int totalPenaltyDays,

        /** Timestamp when the member was created. */
        LocalDateTime createdAt,

        /** Timestamp when the member was last updated. */
        LocalDateTime updatedAt,

        /** Timestamp when the member was logically deleted (if applicable). */
        LocalDateTime deletedAt
) {}

package com.jikkosoft.library.application.dto.member.dto;

/**
 * Summary Data Transfer Object for Member.
 *
 * Responsibilities:
 * - Provides a condensed view of a Member for listings and dropdowns.
 * - Excludes audit fields.
 */
public record MemberSummaryDto(

        /** Unique identifier of the member. */
        Long id,

        /** Full name of the member (firstName + lastName). */
        String fullName,

        /** Email address of the member. */
        String email,

        /** Status of the member. */
        boolean active,

        /** Total penalty days. */
        int totalPenaltyDays
) {}

package com.jikkosoft.library.application.dto.member;

/**
 * Read model for member data.
 */
public record MemberResponse(
        Long id,
        Long userId,
        Long libraryId,
        String firstName,
        String lastName,
        String email,
        boolean active,
        int totalPenaltyDays
) {}

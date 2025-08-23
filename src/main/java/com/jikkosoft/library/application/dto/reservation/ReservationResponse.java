package com.jikkosoft.library.application.dto.reservation;

import java.time.LocalDateTime;

/**
 * Read model for reservation data.
 */
public record ReservationResponse(
        Long id,
        Long memberId,
        Long bookId,
        String status,
        LocalDateTime reservedAt,
        LocalDateTime expiresAt
) {}

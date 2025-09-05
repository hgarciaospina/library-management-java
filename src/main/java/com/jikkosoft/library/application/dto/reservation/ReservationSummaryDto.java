package com.jikkosoft.library.application.dto.reservation;

import java.time.LocalDateTime;

/**
 * Summary Data Transfer Object for Reservation.
 *
 * Responsibilities:
 * - Provides a condensed view of a Reservation for listings.
 * - Excludes audit fields.
 */
public record ReservationSummaryDto(

        /** Unique identifier of the reservation. */
        Long id,

        /** Identifier of the associated Member. */
        Long memberId,

        /** Identifier of the reserved Book. */
        Long bookId,

        /** Status of the reservation (e.g., PENDING, COMPLETED, CANCELLED). */
        String status,

        /** Timestamp when the reservation was made. */
        LocalDateTime reservedAt,

        /** Timestamp when the reservation expires. */
        LocalDateTime expiresAt
) {}

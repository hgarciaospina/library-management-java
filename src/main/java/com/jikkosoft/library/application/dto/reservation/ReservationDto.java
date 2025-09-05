package com.jikkosoft.library.application.dto.reservation;

import java.time.LocalDateTime;

/**
 * Full Data Transfer Object for Reservation.
 *
 * Responsibilities:
 * - Provides a complete and immutable representation of a Reservation entity.
 * - Includes audit metadata (createdAt, updatedAt, deletedAt).
 * - Designed for safe API exposure.
 */
public record ReservationDto(

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
        LocalDateTime expiresAt,

        /** Timestamp when the reservation was created. */
        LocalDateTime createdAt,

        /** Timestamp when the reservation was last updated. */
        LocalDateTime updatedAt,

        /** Timestamp when the reservation was logically deleted (if applicable). */
        LocalDateTime deletedAt
) {}

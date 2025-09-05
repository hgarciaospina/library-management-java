package com.jikkosoft.library.application.dto.reservation;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Command to create a new Reservation.
 *
 * Responsibilities:
 * - Encapsulates all required fields to create a reservation.
 * - Validates inputs at the boundary of the application layer.
 */
@Data
@Builder
public class CreateReservationCommand {

    /** Identifier of the member making the reservation (required). */
    @NotNull(message = "Member ID is required")
    private Long memberId;

    /** Identifier of the book being reserved (required). */
    @NotNull(message = "Book ID is required")
    private Long bookId;

    /** Timestamp when the reservation starts (required). */
    @NotNull(message = "Reservation start time is required")
    private LocalDateTime reservedAt;

    /** Timestamp when the reservation expires (required). */
    @NotNull(message = "Reservation expiration time is required")
    private LocalDateTime expiresAt;
}

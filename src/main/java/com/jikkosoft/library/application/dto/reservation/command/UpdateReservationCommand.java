package com.jikkosoft.library.application.dto.reservation.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Command to update an existing Reservation.
 *
 * Responsibilities:
 * - Encapsulates editable fields of a reservation.
 * - Validates input at the boundary.
 */
@Data
@Builder
public class UpdateReservationCommand {

    /** Identifier of the reservation to update (required). */
    @NotNull(message = "Reservation ID is required")
    private Long id;

    /** Status of the reservation (e.g., PENDING, COMPLETED, CANCELLED). */
    @NotNull(message = "Status is required")
    private String status;

    /** Timestamp when the reservation starts. */
    private LocalDateTime reservedAt;

    /** Timestamp when the reservation expires. */
    private LocalDateTime expiresAt;
}

package com.jikkosoft.library.application.dto.reservation.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to logically delete (soft-delete) a Reservation.
 */
@Data
@Builder
public class DeleteReservationCommand {

    /** Identifier of the reservation to delete (required). */
    @NotNull(message = "Reservation ID is required")
    private Long id;
}

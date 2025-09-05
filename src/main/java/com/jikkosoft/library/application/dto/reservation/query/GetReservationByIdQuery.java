package com.jikkosoft.library.application.dto.reservation.query;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a Reservation by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the Reservation to retrieve.
 * - Immutable structure using Java record.
 */
public record GetReservationByIdQuery(

        /** Identifier of the reservation (required). */
        @NotNull(message = "Reservation ID is required")
        Long id

) {}

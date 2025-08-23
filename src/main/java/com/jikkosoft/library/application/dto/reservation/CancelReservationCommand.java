package com.jikkosoft.library.application.dto.reservation;

/**
 * Command to cancel an existing reservation.
 */
public record CancelReservationCommand(
        Long reservationId,
        Long actorUserId
) {}

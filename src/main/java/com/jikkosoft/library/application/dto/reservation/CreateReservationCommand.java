package com.jikkosoft.library.application.dto.reservation;

/**
 * Command to create a new reservation for a book.
 */
public record CreateReservationCommand(
        Long memberId,
        Long bookId
) {}

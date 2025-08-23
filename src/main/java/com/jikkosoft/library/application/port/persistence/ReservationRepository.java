package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.enums.ReservationStatus;
import com.jikkosoft.library.domain.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Port for Reservation persistence and queries.
 */
public interface ReservationRepository {
    Optional<Reservation> findById(Long id);
    Reservation save(Reservation reservation);

    List<Reservation> findActiveByBookIdOrderByReservedAt(Long bookId);

    List<Reservation> findByStatusAndReservedAtBefore(ReservationStatus status, LocalDateTime threshold);
}

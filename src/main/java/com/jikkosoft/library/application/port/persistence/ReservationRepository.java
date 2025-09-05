package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.application.common.PagedResponse;
import com.jikkosoft.library.domain.enums.ReservationStatus;
import com.jikkosoft.library.domain.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Port for persisting and querying Reservation aggregates.
 *
 * Responsibilities:
 * - Provides CRUD operations (create, read, update, soft delete).
 * - Supports paginated queries.
 * - Supports filtering by book, status, and reservation date.
 */
public interface ReservationRepository {

    /**
     * Retrieves a Reservation by its unique identifier.
     *
     * @param id unique identifier of the reservation
     * @return Optional containing the found Reservation, or empty if not found
     */
    Optional<Reservation> findById(Long id);

    /**
     * Saves a Reservation entity.
     * - If the entity has no ID, it is created.
     * - If the entity has an existing ID, it is updated.
     *
     * @param reservation Reservation entity to persist
     * @return persisted Reservation entity with ID and timestamps populated
     */
    Reservation save(Reservation reservation);

    /**
     * Retrieves active reservations for a given book, ordered by reservation timestamp.
     *
     * @param bookId ID of the book
     * @return list of active reservations
     */
    List<Reservation> findActiveByBookIdOrderByReservedAt(Long bookId);

    /**
     * Retrieves reservations filtered by status and reserved date before a threshold.
     *
     * @param status    reservation status to filter
     * @param threshold date to filter reservations made before
     * @return list of reservations matching the filter
     */
    List<Reservation> findByStatusAndReservedAtBefore(ReservationStatus status, LocalDateTime threshold);

    /**
     * Soft deletes a Reservation by its ID.
     * The record is marked as deleted but not removed from the database.
     *
     * @param id unique identifier of the Reservation
     */
    void logicalDeleteById(Long id);

    /**
     * Retrieves a paginated list of reservations.
     *
     * @param page page number starting from 0
     * @param size number of items per page
     * @return paginated response with reservations
     */
    PagedResponse<Reservation> findAllPaged(int page, int size);

    /**
     * Retrieves a paginated list of reservations filtered by status.
     *
     * @param status reservation status to filter
     * @param page   page number starting from 0
     * @param size   number of items per page
     * @return paginated response with reservations matching the status filter
     */
    PagedResponse<Reservation> findByStatusPaged(ReservationStatus status, int page, int size);
}

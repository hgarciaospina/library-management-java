package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.BookStatus;
import com.jikkosoft.library.domain.enums.ReservationStatus;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Domain model representing a reservation of a specific BookCopy for a Member.
 *
 * Invariants:
 * - A reservation must reference a valid BookCopy and Member.
 * - reservedAt < expiresAt
 * - BookCopy must be AVAILABLE at reservation time (no reservation on non-available copies).
 *
 * Domain rules:
 * - A reservation can be CANCELLED manually.
 * - A reservation EXPIRES automatically if current date > expiresAt and not fulfilled.
 * - A reservation becomes FULFILLED when converted into a Loan (service-level orchestration),
 *   and the BookCopy transitions to ON_LOAN through Loan creation.
 *
 * Note:
 * - Preventing double active reservations for the same copy/time window should be enforced
 *   at service/repository level. This class offers state/consistency checks only.
 */
public class Reservation {

    private final Long id;
    private final BookCopy bookCopy;
    private final Member member;

    private final LocalDate reservedAt;
    private final LocalDate expiresAt;

    private ReservationStatus status;

    public Reservation(Long id, BookCopy bookCopy, Member member, LocalDate reservedAt, LocalDate expiresAt) {
        if (bookCopy == null) throw new IllegalArgumentException("BookCopy must not be null");
        if (member == null) throw new IllegalArgumentException("Member must not be null");
        if (reservedAt == null || expiresAt == null) throw new IllegalArgumentException("Dates must not be null");
        if (!reservedAt.isBefore(expiresAt)) throw new IllegalArgumentException("Reservation must start before it expires");
        if (!bookCopy.isAvailableForReservation()) {
            throw new IllegalStateException("Book copy is not available for reservation");
        }

        this.id = id;
        this.bookCopy = bookCopy;
        this.member = member;
        this.reservedAt = reservedAt;
        this.expiresAt = expiresAt;
        this.status = ReservationStatus.ACTIVE;
    }

    /**
     * Cancels the reservation manually.
     * Allowed only when status is ACTIVE.
     */
    public void cancel() {
        if (status != ReservationStatus.ACTIVE) {
            throw new IllegalStateException("Only ACTIVE reservations can be cancelled");
        }
        this.status = ReservationStatus.CANCELLED;
    }

    /**
     * Expires the reservation automatically if current date is after expiration and still ACTIVE.
     *
     * @param today current date to evaluate expiration
     */
    public void expireIfPast(LocalDate today) {
        if (status == ReservationStatus.ACTIVE && today.isAfter(expiresAt)) {
            this.status = ReservationStatus.EXPIRED;
        }
    }

    /**
     * Marks this reservation as fulfilled.
     * This does not change the BookCopy status directly; the Loan creation will do it.
     * Allowed only when ACTIVE and not expired/cancelled.
     */
    public void markFulfilled() {
        if (status != ReservationStatus.ACTIVE) {
            throw new IllegalStateException("Only ACTIVE reservations can be fulfilled");
        }
        this.status = ReservationStatus.FULFILLED;
    }

    // --- getters ---
    public Long getId() { return id; }
    public BookCopy getBookCopy() { return bookCopy; }
    public Member getMember() { return member; }
    public LocalDate getReservedAt() { return reservedAt; }
    public LocalDate getExpiresAt() { return expiresAt; }
    public ReservationStatus getStatus() { return status; }

    // Equality by identity
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}

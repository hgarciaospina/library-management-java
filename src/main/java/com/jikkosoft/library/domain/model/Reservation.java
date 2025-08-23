package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.ReservationStatus;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Domain model representing a reservation of a specific BookCopy for a Member.
 *
 * Responsibilities:
 * - Tracks the reservation period and status of a BookCopy.
 * - Enforces domain invariants: valid book copy, member, and reservation dates.
 * - Supports status transitions: ACTIVE -> CANCELLED, EXPIRED, FULFILLED.
 *
 * Notes:
 * - Builder pattern ensures safe construction with validation.
 * - Inherits from BaseEntity for audit tracking and soft deletion.
 */
public class Reservation extends BaseEntity {

    private final Long id;
    private final BookCopy bookCopy;
    private final Member member;
    private final LocalDate reservedAt;
    private final LocalDate expiresAt;
    private ReservationStatus status;

    // ======================= Private constructor =======================
    private Reservation(Builder builder) {
        super();
        Objects.requireNonNull(builder.bookCopy, "BookCopy cannot be null");
        Objects.requireNonNull(builder.member, "Member cannot be null");
        Objects.requireNonNull(builder.reservedAt, "ReservedAt date cannot be null");
        Objects.requireNonNull(builder.expiresAt, "ExpiresAt date cannot be null");
        if (!builder.reservedAt.isBefore(builder.expiresAt)) {
            throw new IllegalArgumentException("ReservedAt must be before ExpiresAt");
        }

        this.id = builder.id;
        this.bookCopy = builder.bookCopy;
        this.member = builder.member;
        this.reservedAt = builder.reservedAt;
        this.expiresAt = builder.expiresAt;
        this.status = builder.status != null ? builder.status : ReservationStatus.ACTIVE;
    }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private BookCopy bookCopy;
        private Member member;
        private LocalDate reservedAt;
        private LocalDate expiresAt;
        private ReservationStatus status;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder bookCopy(BookCopy bookCopy) { this.bookCopy = bookCopy; return this; }
        public Builder member(Member member) { this.member = member; return this; }
        public Builder reservedAt(LocalDate reservedAt) { this.reservedAt = reservedAt; return this; }
        public Builder expiresAt(LocalDate expiresAt) { this.expiresAt = expiresAt; return this; }
        public Builder status(ReservationStatus status) { this.status = status; return this; }

        public Reservation build() { return new Reservation(this); }
    }

    // ======================= Getters / Mutators =======================
    public Long getId() { return id; }
    public BookCopy getBookCopy() { return bookCopy; }
    public Member getMember() { return member; }
    public LocalDate getReservedAt() { return reservedAt; }
    public LocalDate getExpiresAt() { return expiresAt; }
    public ReservationStatus getStatus() { return status; }

    /** Cancels the reservation manually, only if currently ACTIVE. */
    public void cancel() {
        if (status != ReservationStatus.ACTIVE) {
            throw new IllegalStateException("Only ACTIVE reservations can be cancelled");
        }
        this.status = ReservationStatus.CANCELLED;
        markUpdated();
    }

    /** Expires the reservation automatically if today > expiresAt and still ACTIVE. */
    public void expireIfPast(LocalDate today) {
        if (status == ReservationStatus.ACTIVE && today.isAfter(expiresAt)) {
            this.status = ReservationStatus.EXPIRED;
            markUpdated();
        }
    }

    /** Marks the reservation as fulfilled, only if currently ACTIVE. */
    public void markFulfilled() {
        if (status != ReservationStatus.ACTIVE) {
            throw new IllegalStateException("Only ACTIVE reservations can be fulfilled");
        }
        this.status = ReservationStatus.FULFILLED;
        markUpdated();
    }

    // ======================= Equals & HashCode =======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", bookCopy=" + (bookCopy != null ? bookCopy.getBarcode() : null) +
                ", member=" + (member != null ? member.getId()  + " " +
                " " + member.getFirstName() + " " + member.getLastName(): null) +
                ", reservedAt=" + reservedAt +
                ", expiresAt=" + expiresAt +
                ", status=" + status +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }
}

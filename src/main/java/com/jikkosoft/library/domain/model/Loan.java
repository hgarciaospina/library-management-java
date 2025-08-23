package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.BookStatus;
import com.jikkosoft.library.domain.enums.LoanStatus;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Domain model representing a Loan transaction.
 *
 * Responsibilities:
 * - Tracks a loan of a BookCopy to a Member.
 * - Tracks loan date, due date, return date, and current status.
 * - Calculates penalties for overdue returns.
 * - Integrates with BaseEntity for audit fields and soft deletion.
 *
 * Invariants:
 * - loanDate <= dueDate
 * - Only active loans can be returned.
 * - Penalties are calculated only for overdue returns.
 *
 * Notes:
 * - Uses Builder pattern for safe construction.
 * - Immutable fields: bookCopy, member, loanDate, dueDate.
 * - Mutable fields: returnDate, status.
 */
public class Loan extends BaseEntity {

    private final Long id;
    private final BookCopy bookCopy;
    private final Member member;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    private LocalDate returnDate; // null if not returned
    private LoanStatus status;

    // ======================= Private constructor =======================
    private Loan(Builder builder) {
        super();
        Objects.requireNonNull(builder.bookCopy, "Book copy must not be null.");
        Objects.requireNonNull(builder.member, "Member must not be null.");
        Objects.requireNonNull(builder.loanDate, "Loan date must not be null.");
        Objects.requireNonNull(builder.dueDate, "Due date must not be null.");
        if (builder.dueDate.isBefore(builder.loanDate)) {
            throw new IllegalArgumentException("Due date cannot be before loan date.");
        }

        this.id = builder.id;
        this.bookCopy = builder.bookCopy;
        this.member = builder.member;
        this.loanDate = builder.loanDate;
        this.dueDate = builder.dueDate;
        this.returnDate = null;
        this.status = LoanStatus.ACTIVE;

        // Transition copy to ON_LOAN
        this.bookCopy.changeStatus(BookStatus.ON_LOAN);
    }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private BookCopy bookCopy;
        private Member member;
        private LocalDate loanDate;
        private LocalDate dueDate;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder bookCopy(BookCopy bookCopy) { this.bookCopy = bookCopy; return this; }
        public Builder member(Member member) { this.member = member; return this; }
        public Builder loanDate(LocalDate loanDate) { this.loanDate = loanDate; return this; }
        public Builder dueDate(LocalDate dueDate) { this.dueDate = dueDate; return this; }

        public Loan build() { return new Loan(this); }
    }

    // ======================= Behavior =======================
    /**
     * Returns the book, enforcing business rules:
     * - Only active loans can be returned.
     * - Return date cannot be before loan date.
     * - BookCopy status updates to AVAILABLE unless LOST or DAMAGED.
     */
    public void returnBook(LocalDate returnDate) {
        Objects.requireNonNull(returnDate, "Return date must not be null.");
        if (returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Return date cannot be before the loan date.");
        }

        this.returnDate = returnDate;
        this.status = LoanStatus.RETURNED;

        // If the copy is still ON_LOAN, set it back to AVAILABLE
        if (bookCopy.getStatus() == BookStatus.ON_LOAN) {
            bookCopy.changeStatus(BookStatus.AVAILABLE);
        }

        markUpdated();
    }

    /**
     * Marks the loan as OVERDUE if today is past due and the book is not returned.
     */
    public void markOverdueIfNeeded(LocalDate today) {
        if (this.returnDate == null && today.isAfter(dueDate)) {
            this.status = LoanStatus.OVERDUE;
            markUpdated();
        }
    }

    /**
     * Calculates penalty days based on overdue days multiplied by category penalty/day.
     * Only applies if the book has been returned late.
     */
    public int calculatePenaltyDays() {
        if (returnDate == null || !returnDate.isAfter(dueDate)) return 0;
        long overdue = returnDate.toEpochDay() - dueDate.toEpochDay();
        int perDay = bookCopy.getBook().getCategory().getPenaltyPerDay();
        return (int) overdue * perDay;
    }

    // ======================= Getters =======================
    public Long getId() { return id; }
    public BookCopy getBookCopy() { return bookCopy; }
    public Member getMember() { return member; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public LoanStatus getStatus() { return status; }

    // ======================= Equals & HashCode =======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", bookCopy=" + (bookCopy != null ? bookCopy.getBarcode() : null) +
                ", member=" + (member != null ? member.getFirstName() + " " + member.getLastName() : null) +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }
}

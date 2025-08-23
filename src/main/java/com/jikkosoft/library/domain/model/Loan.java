package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.BookStatus;
import com.jikkosoft.library.domain.enums.LoanStatus;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Domain model representing a Loan transaction.
 *
 * Invariants:
 * - loanDate <= dueDate
 * - On creation, copy must be AVAILABLE and then transitions to ON_LOAN.
 * - A returned loan cannot be returned again.
 *
 * Business rules:
 * - Penalty days = overdueDays * book.category.penaltyPerDay
 * - Overdue when today > dueDate and not returned.
 */
public class Loan {

    private final Long id;
    private final BookCopy bookCopy;
    private final Member member;

    private final LocalDate loanDate;
    private final LocalDate dueDate;

    private LocalDate returnDate; // null if not returned
    private LoanStatus status;

    public Loan(Long id, BookCopy bookCopy, Member member, LocalDate loanDate, LocalDate dueDate) {
        if (bookCopy == null) throw new IllegalArgumentException("Book copy must not be null.");
        if (member == null) throw new IllegalArgumentException("Member must not be null.");
        if (loanDate == null || dueDate == null) throw new IllegalArgumentException("Dates must not be null.");
        if (dueDate.isBefore(loanDate)) throw new IllegalArgumentException("Due date cannot be before loan date.");
        if (!bookCopy.isAvailableForLoan()) throw new IllegalStateException("Book copy is not available for loan.");

        this.id = id;
        this.bookCopy = bookCopy;
        this.member = member;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.status = LoanStatus.ACTIVE;

        // Transition copy to ON_LOAN on loan creation
        this.bookCopy.changeStatus(BookStatus.ON_LOAN);
    }

    // --- behavior ---
    /**
     * Returns the book on the given date, enforcing business rules:
     * - Return date cannot be before loan date.
     * - A loan cannot be returned more than once.
     * - Upon return:
     *   * status becomes RETURNED
     *   * copy transitions to AVAILABLE unless it was LOST or DAMAGED during the loan
     */
    public void returnBook(LocalDate returnDate) {
        if (returnDate == null) throw new IllegalArgumentException("Return date must not be null.");
        if (this.returnDate != null) throw new IllegalStateException("This loan has already been returned.");
        if (returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Return date cannot be before the loan date.");
        }
        this.returnDate = returnDate;
        this.status = returnDate.isAfter(dueDate) ? LoanStatus.RETURNED : LoanStatus.RETURNED;

        // If the copy wasn't marked LOST or DAMAGED, it becomes AVAILABLE again.
        if (bookCopy.getStatus() == BookStatus.ON_LOAN) {
            bookCopy.changeStatus(BookStatus.AVAILABLE);
        }
    }

    /**
     * Marks the loan as OVERDUE if the current date is past due and the book is not returned.
     */
    public void markOverdueIfNeeded(LocalDate today) {
        if (this.returnDate == null && today.isAfter(dueDate)) {
            this.status = LoanStatus.OVERDUE;
        }
    }

    /**
     * Calculates penalty days based on overdue days multiplied by category penalty/day.
     * If not returned or returned on/before due date, returns 0.
     *
     * @return number of penalty days
     */
    public int calculatePenaltyDays() {
        if (returnDate == null || !returnDate.isAfter(dueDate)) {
            return 0;
        }
        long overdue = returnDate.toEpochDay() - dueDate.toEpochDay();
        int perDay = bookCopy.getBook().getCategory().getPenaltyPerDay();
        return (int) overdue * perDay;
    }

    // --- getters ---
    public Long getId() { return id; }
    public BookCopy getBookCopy() { return bookCopy; }
    public Member getMember() { return member; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public LoanStatus getStatus() { return status; }

    // Equality by identity
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}

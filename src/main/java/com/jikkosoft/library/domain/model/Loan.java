package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.LoanStatus;

import java.time.LocalDate;

/**
 * Domain model representing a loan transaction of a book by a member.
 *
 * Responsibilities:
 * - Tracks the book, member, loan date, due date, and return date.
 * - Calculates overdue penalties based on due date and return date.
 * - Manages state transitions (ACTIVE → RETURNED or OVERDUE).
 *
 * Invariants and validation rules:
 * - A loan always references a {@link Book} and a {@link Member}.
 * - A loan starts with {@link LoanStatus#ACTIVE}.
 * - A returned loan must set a returnDate and update its status.
 */
public class Loan {

    private final Long id;
    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    private LocalDate returnDate;
    private LoanStatus status;

    /**
     * Creates a new Loan.
     *
     * @param id       optional domain identifier (null for transient instances)
     * @param book     borrowed book (must not be null)
     * @param member   borrowing member (must not be null)
     * @param loanDate date of loan (must not be null)
     * @param dueDate  due date for return (must not be null, must be after loanDate)
     */
    public Loan(Long id, Book book, Member member, LocalDate loanDate, LocalDate dueDate) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        if (member == null) throw new IllegalArgumentException("Member cannot be null");
        if (loanDate == null) throw new IllegalArgumentException("Loan date cannot be null");
        if (dueDate == null || dueDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Due date must be after loan date");
        }

        this.id = id;
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.status = LoanStatus.ACTIVE; // default state
    }

    // --- Getters ---
    public Long getId() { return id; }
    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    /**
     * Returns the current loan status.
     *
     * @return loan status (ACTIVE, RETURNED, OVERDUE)
     */
    public LoanStatus getStatus() { return status; }

    // --- Behavior ---

    /**
     * Marks the loan as returned.
     *
     * @param returnDate date when the book was returned (must not be before loanDate)
     */
    public void markAsReturned(LocalDate returnDate) {
        if (returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Return date cannot be before loan date");
        }
        this.returnDate = returnDate;
        this.status = LoanStatus.RETURNED;
    }

    /**
     * Updates loan status based on current date.
     * If the due date has passed and the loan has not been returned,
     * the loan becomes OVERDUE.
     */
    public void updateStatus() {
        if (status == LoanStatus.ACTIVE && LocalDate.now().isAfter(dueDate)) {
            this.status = LoanStatus.OVERDUE;
        }
    }

    /**
     * Calculates penalty days if the loan is overdue.
     * - If returned late, calculates days between dueDate and returnDate.
     * - If still overdue, calculates days between dueDate and today.
     *
     * @return penalty days, 0 if no penalty
     */
    public int calculatePenaltyDays() {
        if (status == LoanStatus.RETURNED && returnDate != null && returnDate.isAfter(dueDate)) {
            return (int) (returnDate.toEpochDay() - dueDate.toEpochDay());
        }
        if (status == LoanStatus.OVERDUE) {
            return (int) (LocalDate.now().toEpochDay() - dueDate.toEpochDay());
        }
        return 0;
    }
}

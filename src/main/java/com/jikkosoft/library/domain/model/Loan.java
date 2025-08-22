package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.BookStatus;
import com.jikkosoft.library.domain.enums.LoanStatus;
import com.jikkosoft.library.domain.vo.PenaltyDays;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a loan transaction of a book copy by a member.
 * Handles penalties, status, and loan rules.
 */
public class Loan {

    private final Long id;
    private final Member member;
    private final BookCopy bookCopy;
    private final LocalDate loanDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatus status;

    public Loan(Long id, Member member, BookCopy bookCopy, LocalDate loanDate, LocalDate dueDate) {
        this.id = id;
        this.member = member;
        this.bookCopy = bookCopy;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.status = LoanStatus.ACTIVE;
    }

    public Long getId() { return id; }
    public Member getMember() { return member; }
    public BookCopy getBookCopy() { return bookCopy; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public LoanStatus getStatus() { return status; }

    /**
     * Registers the return of the book copy.
     * Updates loan status and book copy availability.
     * Throws exception if return is before loan date.
     */
    public void registerReturn(LocalDate returnDate) {
        if (returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Return date cannot be before loan date");
        }
        this.returnDate = returnDate;
        if (returnDate.isAfter(dueDate)) {
            this.status = LoanStatus.OVERDUE;
        } else {
            this.status = LoanStatus.RETURNED;
        }
        bookCopy.setStatus(BookStatus.AVAILABLE);
    }

    /**
     * Calculates penalty days based on overdue days.
     * @return number of penalty days
     */
    public int calculatePenaltyDays() {
        if (returnDate == null || !returnDate.isAfter(dueDate)) {
            return 0;
        }
        long overdue = returnDate.toEpochDay() - dueDate.toEpochDay();
        return (int) overdue; // Multiply by category penalty if needed
    }
}

package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.vo.Email;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a library member.
 * Members are users registered to a specific library.
 * Can have multiple loans.
 */
public class Member {

    private final Long id;
    private final User user;
    private final Library library;
    private final Set<Loan> loans = new HashSet<>();
    private boolean active;

    public Member(Long id, User user, Library library) {
        this.id = id;
        this.user = user;
        this.library = library;
        this.active = true;
    }

    public Long getId() { return id; }
    public User getUser() { return user; }
    public Library getLibrary() { return library; }
    public Set<Loan> getLoans() { return loans; }
    public boolean isActive() { return active; }

    public void addLoan(Loan loan) { loans.add(loan); }

    public void deactivate() { this.active = false; }
    public void activate() { this.active = true; }

    /**
     * Calculates total penalty days across all overdue loans.
     * @return total penalty days
     */
    public int calculateTotalPenalty() {
        return loans.stream()
                .filter(loan -> loan.getStatus() == com.jikkosoft.library.domain.enums.LoanStatus.OVERDUE)
                .mapToInt(Loan::calculatePenaltyDays)
                .sum();
    }

    /**
     * Checks if member can borrow new books.
     * Members with total penalty days > 0 cannot borrow.
     * @return true if allowed
     */
    public boolean canBorrow() {
        return calculateTotalPenalty() == 0 && active;
    }
}

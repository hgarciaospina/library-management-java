package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.LoanStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Domain model representing a library member.
 *
 * Responsibilities:
 * - Identifies a member with a unique ID, first name, last name, and email.
 * - Tracks all loan transactions ({@link Loan}) associated with the member.
 * - Provides queries for active loans, overdue loans, and penalty calculations.
 *
 * Invariants:
 * - firstName, lastName, and email must not be null or empty.
 * - email should be unique in the system (enforced externally).
 * - Loans are always linked to the member that created them.
 */
public class Member {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;

    private final List<Loan> loans;

    /**
     * Creates a new Member.
     *
     * @param id        optional domain identifier (null for transient instances)
     * @param firstName member's first name (required, not blank)
     * @param lastName  member's last name (required, not blank)
     * @param email     member's email address (required, not blank)
     */
    public Member(Long id, String firstName, String lastName, String email) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("Member first name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Member last name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Member email cannot be null or blank");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.loans = new ArrayList<>();
    }

    // --- Getters ---
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    /**
     * Returns full name concatenating firstName + lastName.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns an immutable view of all loans of the member.
     */
    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }

    // --- Behavior ---

    /**
     * Adds a loan to this member.
     * (Should be called only when creating a new Loan instance.)
     *
     * @param loan the loan to add
     */
    public void addLoan(Loan loan) {
        if (loan == null) {
            throw new IllegalArgumentException("Loan cannot be null");
        }
        loans.add(loan);
    }

    /**
     * Returns a list of currently active loans.
     *
     * @return list of loans with status ACTIVE
     */
    public List<Loan> getActiveLoans() {
        return loans.stream()
                .filter(loan -> loan.getStatus() == LoanStatus.ACTIVE)
                .toList();
    }

    /**
     * Returns a list of overdue loans.
     *
     * @return list of loans with status OVERDUE
     */
    public List<Loan> getOverdueLoans() {
        return loans.stream()
                .filter(loan -> loan.getStatus() == LoanStatus.OVERDUE)
                .toList();
    }

    /**
     * Calculates the total accumulated penalty days across all overdue or late-returned loans.
     *
     * @return total penalty days
     */
    public int calculateTotalPenaltyDays() {
        return loans.stream()
                .mapToInt(Loan::calculatePenaltyDays)
                .sum();
    }

    /**
     * Returns true if the member has any overdue loans.
     */
    public boolean hasOverdueLoans() {
        return loans.stream().anyMatch(l -> l.getStatus() == LoanStatus.OVERDUE);
    }
}

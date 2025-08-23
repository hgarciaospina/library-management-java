package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.LoanStatus;
import com.jikkosoft.library.domain.vo.Email;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Domain model representing a library member.
 *
 * Responsibilities:
 * - Identifies a member with a unique ID, name, and email.
 * - Tracks all loan transactions ({@link Loan}) associated with the member.
 * - Provides queries for active loans, overdue loans, and penalty calculations.
 *
 * Invariants:
 * - firstName, lastName, and email must not be null or empty.
 * - email should be unique in the system (enforced externally).
 */
public class Member {

    private final Long id;
    private String firstName;
    private String lastName;
    private Email email;

    private final List<Loan> loans;

    public Member(Long id, String firstName, String lastName, Email email) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("Member firstName cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Member lastName cannot be null or blank");
        }
        if (email == null) {
            throw new IllegalArgumentException("Member email cannot be null");
        }
        this.id = id;
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.email = email;
        this.loans = new ArrayList<>();
    }

    // --- Getters / Mutators ---
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("firstName cannot be blank");
        this.firstName = firstName.trim();
    }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("lastName cannot be blank");
        this.lastName = lastName.trim();
    }
    public Email getEmail() { return email; }
    public void setEmail(Email email) {
        if (email == null) throw new IllegalArgumentException("email cannot be null");
        this.email = email;
    }

    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }

    // --- Behavior ---
    /** Adds a loan to this member. */
    public void addLoan(Loan loan) {
        if (loan == null) throw new IllegalArgumentException("Loan cannot be null");
        loans.add(loan);
    }

    /** Returns a list of currently active loans. */
    public List<Loan> getActiveLoans() {
        return loans.stream().filter(l -> l.getStatus() == LoanStatus.ACTIVE).toList();
    }

    /** Returns a list of overdue loans. */
    public List<Loan> getOverdueLoans() {
        return loans.stream().filter(l -> l.getStatus() == LoanStatus.OVERDUE).toList();
    }

    /**
     * Calculates the total accumulated penalty days across all loans.
     * (Loan already encapsulates the category penalty/day.)
     */
    public int calculateTotalPenaltyDays() {
        return loans.stream().mapToInt(Loan::calculatePenaltyDays).sum();
    }

    /** Returns true if the member has any overdue loans. */
    public boolean hasOverdueLoans() {
        return loans.stream().anyMatch(l -> l.getStatus() == LoanStatus.OVERDUE);
    }
}

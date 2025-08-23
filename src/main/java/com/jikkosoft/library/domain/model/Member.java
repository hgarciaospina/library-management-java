package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.LoanStatus;
import com.jikkosoft.library.domain.vo.Email;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
 *
 * Notes:
 * - Builder pattern is used for safe construction.
 * - Inherits from BaseEntity for audit tracking and soft deletion.
 */
public class Member extends BaseEntity {

    private final Long id;
    private String firstName;
    private String lastName;
    private Email email;
    private final List<Loan> loans;

    // ======================= Private constructor =======================
    private Member(Builder builder) {
        super();
        Objects.requireNonNull(builder.firstName, "First name cannot be null");
        Objects.requireNonNull(builder.lastName, "Last name cannot be null");
        Objects.requireNonNull(builder.email, "Email cannot be null");

        if (builder.firstName.isBlank()) throw new IllegalArgumentException("First name cannot be blank");
        if (builder.lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be blank");

        this.id = builder.id;
        this.firstName = builder.firstName.trim();
        this.lastName = builder.lastName.trim();
        this.email = builder.email;
        this.loans = new ArrayList<>();
    }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private Email email;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder email(Email email) { this.email = email; return this; }

        public Member build() { return new Member(this); }
    }

    // ======================= Getters / Mutators =======================
    public Long getId() { return id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("First name cannot be blank");
        this.firstName = firstName.trim();
        markUpdated();
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be blank");
        this.lastName = lastName.trim();
        markUpdated();
    }

    public Email getEmail() { return email; }
    public void setEmail(Email email) {
        Objects.requireNonNull(email, "Email cannot be null");
        this.email = email;
        markUpdated();
    }

    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }

    // ======================= Behavior =======================
    /** Adds a loan to this member. */
    public void addLoan(Loan loan) {
        Objects.requireNonNull(loan, "Loan cannot be null");
        loans.add(loan);
        markUpdated();
    }

    /** Returns a list of currently active loans. */
    public List<Loan> getActiveLoans() {
        return loans.stream().filter(l -> l.getStatus() == LoanStatus.ACTIVE).toList();
    }

    /** Returns a list of overdue loans. */
    public List<Loan> getOverdueLoans() {
        return loans.stream().filter(l -> l.getStatus() == LoanStatus.OVERDUE).toList();
    }

    /** Calculates the total accumulated penalty days across all loans. */
    public int calculateTotalPenaltyDays() {
        return loans.stream().mapToInt(Loan::calculatePenaltyDays).sum();
    }

    /** Returns true if the member has any overdue loans. */
    public boolean hasOverdueLoans() {
        return loans.stream().anyMatch(l -> l.getStatus() == LoanStatus.OVERDUE);
    }

    // ======================= Equals & HashCode =======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", loansCount=" + loans.size() +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }
}

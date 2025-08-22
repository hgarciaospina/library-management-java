package com.jikkosoft.library.domain.enums;

/**
 * Enum representing the status of a loan transaction.
 * Used in Loan entities and for penalty and notification calculations.
 */
public enum LoanStatus {
    ACTIVE,
    RETURNED,
    OVERDUE
}

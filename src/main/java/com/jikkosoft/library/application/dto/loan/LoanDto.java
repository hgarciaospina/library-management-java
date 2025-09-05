package com.jikkosoft.library.application.dto.loan;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Full Data Transfer Object for Loan.
 *
 * Responsibilities:
 * - Provides a complete and immutable representation of a Loan entity.
 * - Includes all relevant fields and audit metadata.
 * - Designed for safe exposure to API clients.
 */
public record LoanDto(

        /** Unique identifier of the loan. */
        Long loanId,

        /** Identifier of the member associated with the loan. */
        Long memberId,

        /** Identifier of the book copy associated with the loan. */
        Long bookCopyId,

        /** Status of the loan (e.g., ACTIVE, RETURNED, OVERDUE). */
        String status,

        /** Date when the loan was initiated. */
        LocalDate loanDate,

        /** Due date for returning the loaned item. */
        LocalDate dueDate,

        /** Actual return date (nullable if not returned yet). */
        LocalDate returnDate,

        /** Number of penalty days accrued. */
        int penaltyDays,

        /** Timestamp when the loan was created. */
        LocalDateTime createdAt,

        /** Timestamp when the loan was last updated. */
        LocalDateTime updatedAt,

        /** Timestamp when the loan was logically deleted (if applicable). */
        LocalDateTime deletedAt
) {}

package com.jikkosoft.library.application.dto.loan.dto;

import java.time.LocalDate;

/**
 * Summary Data Transfer Object for Loan.
 *
 * Responsibilities:
 * - Provides a condensed view of a Loan for listings and quick lookups.
 * - Excludes audit fields.
 */
public record LoanSummaryDto(

        /** Unique identifier of the loan. */
        Long loanId,

        /** Member name (for listing purposes). */
        String memberName,

        /** Book copy title. */
        String bookTitle,

        /** Status of the loan. */
        String status,

        /** Loan date. */
        LocalDate loanDate,

        /** Due date for return. */
        LocalDate dueDate
) {}

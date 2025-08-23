package com.jikkosoft.library.application.dto.loan;

import java.time.LocalDate;

/**
 * Read model for loan data.
 */
public record LoanResponse(
        Long loanId,
        Long memberId,
        Long bookCopyId,
        String status,
        LocalDate loanDate,
        LocalDate dueDate,
        LocalDate returnDate,
        int penaltyDays
) {}

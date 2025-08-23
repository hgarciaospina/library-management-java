package com.jikkosoft.library.application.dto.loan;

/**
 * Command to create a new Loan.
 */
public record LendBookCommand(
        Long memberId,
        Long bookId,
        Long libraryId
) {}

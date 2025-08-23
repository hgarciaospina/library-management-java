package com.jikkosoft.library.application.dto.loan;

import java.time.LocalDate;

/**
 * Command to return a loaned book copy.
 */
public record ReturnBookCommand(
        Long loanId,
        LocalDate returnDate
) {}

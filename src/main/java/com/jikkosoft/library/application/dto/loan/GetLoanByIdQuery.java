package com.jikkosoft.library.application.dto.loan;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a Loan by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the Loan to retrieve.
 * - Immutable structure using Java record.
 */
public record GetLoanByIdQuery(

        /** Identifier of the Loan (required). */
        @NotNull(message = "Loan ID is required")
        Long loanId

) {}

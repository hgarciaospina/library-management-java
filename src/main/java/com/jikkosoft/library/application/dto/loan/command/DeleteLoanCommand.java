package com.jikkosoft.library.application.dto.loan.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to logically delete (soft-delete) a Loan.
 */
@Data
@Builder
public class DeleteLoanCommand {

    /** Unique identifier of the loan to delete (required). */
    @NotNull(message = "Loan ID is required")
    private Long loanId;
}

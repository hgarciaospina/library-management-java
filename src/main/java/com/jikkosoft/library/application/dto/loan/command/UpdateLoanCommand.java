package com.jikkosoft.library.application.dto.loan.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Command to update an existing Loan.
 *
 * Responsibilities:
 * - Encapsulates editable fields of a Loan.
 * - Ensures validation at the boundary using Jakarta Validation.
 */
@Data
@Builder
public class UpdateLoanCommand {

    /** Unique identifier of the loan to update (required). */
    @NotNull(message = "Loan ID is required")
    private Long loanId;

    /** Status of the loan (required). */
    @NotNull(message = "Loan status is required")
    private String status;

    /** Actual return date (nullable, set when book is returned). */
    private LocalDate returnDate;

    /** Number of penalty days (optional, auto-calculated if not provided). */
    private Integer penaltyDays;
}

package com.jikkosoft.library.application.dto.loan;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Command to create a new Loan.
 *
 * Responsibilities:
 * - Encapsulates required fields to create a loan.
 * - Ensures validation at the boundary using Jakarta Validation.
 */
@Data
@Builder
public class CreateLoanCommand {

    /** Identifier of the member taking the loan (required). */
    @NotNull(message = "Member ID is required")
    private Long memberId;

    /** Identifier of the book copy being loaned (required). */
    @NotNull(message = "Book copy ID is required")
    private Long bookCopyId;

    /** Date when the loan starts (required). */
    @NotNull(message = "Loan date is required")
    private LocalDate loanDate;

    /** Due date for returning the loaned item (required). */
    @NotNull(message = "Due date is required")
    private LocalDate dueDate;
}

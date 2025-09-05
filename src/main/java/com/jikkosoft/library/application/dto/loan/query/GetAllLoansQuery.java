package com.jikkosoft.library.application.dto.loan.query;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

/**
 * Query to retrieve all Loans with optional filtering, pagination, and sorting.
 *
 * Responsibilities:
 * - Extends BaseQuery for pagination and sorting.
 * - Allows optional filtering by member, book copy, status, and date ranges.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllLoansQuery extends BaseQuery {

    /** Optional filter by member ID. */
    private Long memberId;

    /** Optional filter by book copy ID. */
    private Long bookCopyId;

    /** Optional filter by status (e.g., ACTIVE, RETURNED). */
    private String status;

    /** Optional filter: loan date from. */
    private LocalDate loanDateFrom;

    /** Optional filter: loan date to. */
    private LocalDate loanDateTo;

    // ================= Constructors =================
    public GetAllLoansQuery() {
        super();
    }

    public GetAllLoansQuery(int page, int size, String sortBy, String sortDirection, String searchTerm,
                            Long memberId, Long bookCopyId, String status,
                            LocalDate loanDateFrom, LocalDate loanDateTo) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.memberId = memberId;
        this.bookCopyId = bookCopyId;
        this.status = status;
        this.loanDateFrom = loanDateFrom;
        this.loanDateTo = loanDateTo;
    }
}

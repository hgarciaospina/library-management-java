package com.jikkosoft.library.application.dto.reservation.query;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Query to retrieve all Reservations with optional filtering, pagination, and sorting.
 *
 * Responsibilities:
 * - Extends BaseQuery for pagination and sorting.
 * - Allows optional filtering by member, book, status, or date range.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllReservationsQuery extends BaseQuery {

    /** Optional filter by Member ID. */
    private Long memberId;

    /** Optional filter by Book ID. */
    private Long bookId;

    /** Optional filter by reservation status. */
    private String status;

    /** Optional filter by reservation start date. */
    private LocalDateTime reservedFrom;

    /** Optional filter by reservation end date. */
    private LocalDateTime reservedTo;

    // ================= Constructors =================
    public GetAllReservationsQuery() {
        super();
    }

    public GetAllReservationsQuery(int page, int size, String sortBy, String sortDirection, String searchTerm,
                                   Long memberId, Long bookId, String status,
                                   LocalDateTime reservedFrom, LocalDateTime reservedTo) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.memberId = memberId;
        this.bookId = bookId;
        this.status = status;
        this.reservedFrom = reservedFrom;
        this.reservedTo = reservedTo;
    }
}

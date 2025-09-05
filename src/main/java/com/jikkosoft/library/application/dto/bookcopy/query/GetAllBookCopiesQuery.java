package com.jikkosoft.library.application.dto.bookcopy.query;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.EqualsAndHashCode;

/**
 * Query to retrieve all BookCopies with pagination, sorting, and filtering.
 *
 * Responsibilities:
 * - Extends {@link BaseQuery} to support pagination and sorting.
 * - Allows optional filtering by book, library, status, and barcode.
 */
@EqualsAndHashCode(callSuper = true)
public class GetAllBookCopiesQuery extends BaseQuery {

    /** Optional filter by associated Book ID. */
    private Long bookId;

    /** Optional filter by associated Library ID. */
    private Long libraryId;

    /** Optional filter by status (AVAILABLE, LOANED, RESERVED, LOST, DAMAGED). */
    private String status;

    /** Optional filter by barcode (unique physical identifier). */
    private String barcode;

    // ================= Constructors =================

    public GetAllBookCopiesQuery() {
        super();
    }

    public GetAllBookCopiesQuery(
            int page,
            int size,
            String sortBy,
            String sortDirection,
            String searchTerm,
            Long bookId,
            Long libraryId,
            String status,
            String barcode
    ) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.bookId = bookId;
        this.libraryId = libraryId;
        this.status = status;
        this.barcode = barcode;
    }

    // ================= Getters/Setters =================

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public Long getLibraryId() { return libraryId; }
    public void setLibraryId(Long libraryId) { this.libraryId = libraryId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
}

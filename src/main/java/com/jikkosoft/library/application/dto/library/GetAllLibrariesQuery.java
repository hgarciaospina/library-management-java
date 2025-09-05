package com.jikkosoft.library.application.dto.library;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Query to retrieve all Libraries with pagination, sorting, and optional filtering.
 *
 * Responsibilities:
 * - Extends {@link BaseQuery} to support pagination, sorting, and global search term.
 * - Can optionally filter libraries by name or address.
 * - Designed for safe and efficient retrieval of Library summary data.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllLibrariesQuery extends BaseQuery {

    /** Optional filter by library name. */
    private String name;

    /** Optional filter by library address. */
    private String address;

    // ================= Constructors =================
    public GetAllLibrariesQuery() {
        super();
    }

    public GetAllLibrariesQuery(
            int page,
            int size,
            String sortBy,
            String sortDirection,
            String searchTerm,
            String name,
            String address
    ) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.name = name;
        this.address = address;
    }
}

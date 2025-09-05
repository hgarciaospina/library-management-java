package com.jikkosoft.library.application.dto.member;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Query to retrieve all Members with optional filtering, pagination, and sorting.
 *
 * Responsibilities:
 * - Extends BaseQuery for pagination and sorting.
 * - Allows optional filtering by library, active status, or name.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllMembersQuery extends BaseQuery {

    /** Optional filter by Library ID. */
    private Long libraryId;

    /** Optional filter by active status. */
    private Boolean active;

    /** Optional filter by member name (firstName + lastName). */
    private String name;

    // ================= Constructors =================
    public GetAllMembersQuery() {
        super();
    }

    public GetAllMembersQuery(int page, int size, String sortBy, String sortDirection, String searchTerm,
                              Long libraryId, Boolean active, String name) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.libraryId = libraryId;
        this.active = active;
        this.name = name;
    }
}

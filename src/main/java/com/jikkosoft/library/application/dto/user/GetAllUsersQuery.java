package com.jikkosoft.library.application.dto.user;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Query to retrieve all Users with optional filtering, pagination, and sorting.
 *
 * Responsibilities:
 * - Extends BaseQuery for pagination and sorting.
 * - Allows optional filtering by email, active status, or roles.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllUsersQuery extends BaseQuery {

    /** Optional filter by email. */
    private String email;

    /** Optional filter by active status. */
    private Boolean active;

    /** Optional filter by role name. */
    private String role;

    // ================= Constructors =================
    public GetAllUsersQuery() {
        super();
    }

    public GetAllUsersQuery(int page, int size, String sortBy, String sortDirection, String searchTerm,
                            String email, Boolean active, String role) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.email = email;
        this.active = active;
        this.role = role;
    }
}

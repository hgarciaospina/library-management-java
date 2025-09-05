package com.jikkosoft.library.application.dto.role.query;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.jikkosoft.library.domain.enums.RoleType;

/**
 * Query to retrieve all Roles with optional filtering, pagination, and sorting.
 *
 * Responsibilities:
 * - Extends BaseQuery for pagination and sorting.
 * - Allows optional filtering by roleType.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllRolesQuery extends BaseQuery {

    /** Optional filter by RoleType. */
    private RoleType roleType;

    // ================= Constructors =================
    public GetAllRolesQuery() {
        super();
    }

    public GetAllRolesQuery(int page, int size, String sortBy, String sortDirection, String searchTerm,
                            RoleType roleType) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.roleType = roleType;
    }
}

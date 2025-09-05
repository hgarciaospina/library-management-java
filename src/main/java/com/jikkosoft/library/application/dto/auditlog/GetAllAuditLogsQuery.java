package com.jikkosoft.library.application.dto.auditlog;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.jikkosoft.library.domain.enums.AuditAction;

/**
 * Query to retrieve all AuditLog entries.
 *
 * Responsibilities:
 * - Supports pagination, sorting, and optional filtering by action type or user ID.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllAuditLogsQuery extends BaseQuery {

    /** Optional filter by action type. */
    private AuditAction action;

    /** Optional filter by user ID who performed the action. */
    private Long performedById;

    // ================= Constructors =================
    public GetAllAuditLogsQuery() {
        super();
    }

    public GetAllAuditLogsQuery(
            int page,
            int size,
            String sortBy,
            String sortDirection,
            String searchTerm,
            AuditAction action,
            Long performedById
    ) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.action = action;
        this.performedById = performedById;
    }
}

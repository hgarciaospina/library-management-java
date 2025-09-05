package com.jikkosoft.library.application.dto.auditlog.query;

import com.jikkosoft.library.application.common.BaseQuery;
import com.jikkosoft.library.domain.enums.AuditAction;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Query to retrieve all AuditLog entries.
 *
 * Responsibilities:
 * - Supports pagination, sorting, and optional filtering by action type or user ID.
 * - Extends BaseQuery to inherit common query parameters.
 * - Can be used in services or repositories to fetch filtered audit logs.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllAuditLogsQuery extends BaseQuery {

    /** Optional filter by action type. */
    private AuditAction action;

    /** Optional filter by user ID who performed the action. */
    private Long performedById;

    // ================= Constructors =================

    /**
     * Default constructor.
     * Initializes an empty query with default pagination and sorting.
     */
    public GetAllAuditLogsQuery() {
        super(); // calls BaseQuery no-args constructor
    }

    /**
     * Parameterized constructor.
     * Initializes the query with pagination, sorting, search term, and optional filters.
     *
     * @param page Page number, starting at 0.
     * @param size Page size (number of items per page).
     * @param sortBy Field to sort by.
     * @param sortDirection Sort direction: ASC or DESC.
     * @param searchTerm Generic search term.
     * @param action Optional filter by AuditAction.
     * @param performedById Optional filter by user ID.
     */
    public GetAllAuditLogsQuery(
            int page,
            int size,
            String sortBy,
            String sortDirection,
            String searchTerm,
            AuditAction action,
            Long performedById
    ) {
        // Call BaseQuery all-args constructor to initialize inherited fields
        super(page, size, sortBy, sortDirection, searchTerm);

        // Initialize local fields
        this.action = action;
        this.performedById = performedById;
    }
}

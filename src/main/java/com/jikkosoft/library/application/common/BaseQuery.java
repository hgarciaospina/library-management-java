package com.jikkosoft.library.application.common;

import lombok.Data;

/**
 * Base query for all entity queries.
 *
 * Responsibilities:
 * - Provides pagination (page, size).
 * - Provides dynamic sorting (sortBy, sortDirection).
 * - Provides a generic search term (can be extended per entity).
 *
 * Notes:
 * - All entity queries should extend this class.
 * - Constructors are protected to enforce usage via subclasses.
 */
@Data
public abstract class BaseQuery {

    /** Page number, starting at 0. */
    private int page = 0;

    /** Page size (items per page). */
    private int size = 10;

    /** Field to sort by (e.g., "title", "name"). */
    private String sortBy = "id";

    /** Sort direction: ASC or DESC. */
    private String sortDirection = "ASC";

    /** Generic search term (can be refined in specific queries). */
    private String searchTerm;

    /**
     * Protected no-args constructor for subclass flexibility.
     */
    protected BaseQuery() {
        // default values are already set in field declarations
    }

    /**
     * Protected all-args constructor to allow subclasses to initialize inherited fields.
     *
     * @param page Page number, starting at 0.
     * @param size Page size (number of items per page).
     * @param sortBy Field to sort by.
     * @param sortDirection Sort direction: ASC or DESC.
     * @param searchTerm Generic search term.
     */
    protected BaseQuery(int page, int size, String sortBy, String sortDirection, String searchTerm) {
        this.page = page;
        this.size = size;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
        this.searchTerm = searchTerm;
    }
}

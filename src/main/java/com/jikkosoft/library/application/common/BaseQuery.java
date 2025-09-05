package com.jikkosoft.library.application.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

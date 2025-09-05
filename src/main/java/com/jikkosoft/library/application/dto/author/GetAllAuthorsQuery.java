package com.jikkosoft.library.application.query.author;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Query to retrieve all Authors with pagination, sorting, and filtering.
 *
 * Responsibilities:
 * - Extends {@link BaseQuery} to support pagination and sorting.
 * - Allows optional filtering by nationality and name.
 * - Name filter is applied against both firstName and lastName fields.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetAllAuthorsQuery extends BaseQuery {

    /** Optional filter by nationality. */
    private String nationality;

    /** Optional filter by name (applies to firstName + lastName). */
    private String name;

    /**
     * Full constructor with pagination, sorting and filtering.
     *
     * @param page          page number (0-based)
     * @param size          number of elements per page
     * @param sortBy        property to sort by
     * @param sortDirection sorting direction ("asc" or "desc")
     * @param searchTerm    generic search term (applies to multiple fields)
     * @param nationality   optional filter by nationality
     * @param name          optional filter by author name
     */
    public GetAllAuthorsQuery(
            int page,
            int size,
            String sortBy,
            String sortDirection,
            String searchTerm,
            String nationality,
            String name
    ) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.nationality = nationality;
        this.name = name;
    }
}

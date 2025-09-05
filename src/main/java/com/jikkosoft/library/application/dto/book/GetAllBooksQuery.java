package com.jikkosoft.library.application.dto.book;

import com.jikkosoft.library.application.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Query to retrieve all Books with pagination, sorting and filtering.
 *
 * Responsibilities:
 * - Extends {@link BaseQuery} to support pagination and sorting.
 * - Allows optional filtering by title, category, author, and publication year.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllBooksQuery extends BaseQuery {

    /** Optional filter by title. */
    private String title;

    /** Optional filter by category. */
    private Long categoryId;

    /** Optional filter by author. */
    private Long authorId;

    /** Optional filter by publication year. */
    private Integer publicationYear;

    // ================= Constructors =================
    public GetAllBooksQuery() {
        super();
    }

    public GetAllBooksQuery(
            int page,
            int size,
            String sortBy,
            String sortDirection,
            String searchTerm,
            String title,
            Long categoryId,
            Long authorId,
            Integer publicationYear
    ) {
        super(page, size, sortBy, sortDirection, searchTerm);
        this.title = title;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.publicationYear = publicationYear;
    }
}

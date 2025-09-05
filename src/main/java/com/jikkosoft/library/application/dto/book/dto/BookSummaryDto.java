package com.jikkosoft.library.application.dto.book.dto;

import com.jikkosoft.library.application.dto.author.dto.AuthorSummaryDto;
import com.jikkosoft.library.application.dto.category.dto.CategorySummaryDto;

import java.util.List;

/**
 * Summary Data Transfer Object for Book.
 *
 * Responsibilities:
 * - Provides a lightweight, immutable representation of a Book.
 * - Designed for listings, catalogs, and dropdowns.
 * - Excludes audit fields for efficiency.
 */
public record BookSummaryDto(

        /** Unique identifier of the book. */
        Long id,

        /** Title of the book. */
        String title,

        /** Year of publication (nullable for flexibility). */
        Integer publicationYear,

        /** International Standard Book Number. */
        String isbn,

        /** List of associated authors (summary view). */
        List<AuthorSummaryDto> authors,

        /** Category to which the book belongs (summary view). */
        CategorySummaryDto category
) {}

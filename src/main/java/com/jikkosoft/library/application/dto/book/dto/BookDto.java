package com.jikkosoft.library.application.dto.book.dto;

import com.jikkosoft.library.application.dto.author.dto.AuthorSummaryDto;
import com.jikkosoft.library.application.dto.category.dto.CategorySummaryDto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Full Data Transfer Object for Book.
 *
 * Responsibilities:
 * - Provides a complete and immutable representation of a Book entity.
 * - Includes metadata such as authors, category, and audit fields.
 * - Designed for safe exposure to API clients.
 */
public record BookDto(

        /** Unique identifier of the book. */
        Long id,

        /** International Standard Book Number. */
        String isbn,

        /** Title of the book. */
        String title,

        /** Year of publication (nullable for flexibility). */
        Integer publicationYear,

        /** List of associated authors (summary view). */
        List<AuthorSummaryDto> authors,

        /** Category to which the book belongs (summary view). */
        CategorySummaryDto category,

        /** Timestamp when the book was created. */
        LocalDateTime createdAt,

        /** Timestamp when the book was last updated. */
        LocalDateTime updatedAt,

        /** Timestamp when the book was logically deleted (if applicable). */
        LocalDateTime deletedAt
) {}

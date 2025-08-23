package com.jikkosoft.library.application.dto.book;

import java.util.List;

/**
 * Data Transfer Object representing a Book entity.
 */
public record BookDto(
        Long id,
        String title,
        String isbn,
        String publisher,
        int publicationYear,
        List<Long> authorIds
) {}
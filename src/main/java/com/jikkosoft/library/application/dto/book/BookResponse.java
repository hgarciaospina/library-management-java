package com.jikkosoft.library.application.dto.book;

import java.util.List;

/**
 * Read model for book data returned by use cases.
 */
public record BookResponse(
        Long id,
        String isbn,
        String title,
        int publicationYear,
        String categoryName,
        List<String> authors
) {}

package com.jikkosoft.library.application.dto.book;

import java.util.List;

/**
 * Command to update an existing Book.
 */
public record UpdateBookCommand(
        Long id,
        String title,
        String isbn,
        String publisher,
        int publicationYear,
        List<Long> authorIds
) {}

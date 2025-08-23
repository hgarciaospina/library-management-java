package com.jikkosoft.library.application.dto.book;

/**
 * Command for creating a new Book aggregate.
 */
public record CreateBookCommand(
        String isbn,
        String title,
        int publicationYear,
        Long categoryId
) {}

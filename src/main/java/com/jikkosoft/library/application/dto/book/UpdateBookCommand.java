package com.jikkosoft.library.application.dto.book;

/**
 * Command for updating mutable fields of a Book.
 */
public record UpdateBookCommand(
        Long bookId,
        String title,
        Integer publicationYear,
        Long categoryId
) {}

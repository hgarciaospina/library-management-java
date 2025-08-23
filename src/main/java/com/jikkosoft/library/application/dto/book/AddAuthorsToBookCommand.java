package com.jikkosoft.library.application.dto.book;

import java.util.List;

/**
 * Command to associate authors to a book.
 * Authors are referenced by their IDs.
 */
public record AddAuthorsToBookCommand(
        Long bookId,
        List<Long> authorIds
) {}

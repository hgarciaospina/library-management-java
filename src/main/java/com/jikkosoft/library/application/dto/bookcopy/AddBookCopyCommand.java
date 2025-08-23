package com.jikkosoft.library.application.dto.bookcopy;

/**
 * Command to add a new physical copy of a book to a library.
 */
public record AddBookCopyCommand(
        Long bookId,
        Long libraryId,
        String shelfLocation
) {}

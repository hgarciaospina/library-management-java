package com.jikkosoft.library.application.dto.bookcopy;

/**
 * Read model for book copy data.
 */
public record BookCopyResponse(
        Long id,
        Long bookId,
        Long libraryId,
        int copyNumber,
        String status,
        String shelfLocation
) {}

package com.jikkosoft.library.application.dto.bookcopy;

/**
 * Command to create a new BookCopy.
 */
public record CreateBookCopyCommand(
        Long bookId,
        Long libraryId,
        Integer copyNumber,
        String barcode,
        String shelfLocation
) {}

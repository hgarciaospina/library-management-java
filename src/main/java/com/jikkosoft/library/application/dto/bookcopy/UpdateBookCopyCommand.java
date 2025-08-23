package com.jikkosoft.library.application.dto.bookcopy;

public record UpdateBookCopyCommand(
        Long id,
        Long bookId,
        Long libraryId,
        Integer copyNumber,
        String barcode,
        String status,
        String shelfLocation
) {}

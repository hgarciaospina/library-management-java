package com.jikkosoft.library.application.dto.bookcopy;

/**
 * Data Transfer Object representing a BookCopy entity.
 */
public record BookCopyDto(
        Long id,
        Long bookId,
        Long libraryId,
        Integer copyNumber,
        String barcode,
        String status,
        String shelfLocation
) {}
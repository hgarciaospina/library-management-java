package com.jikkosoft.library.application.dto.bookcopy;

/**
 * Command to move a book copy to a new shelf/location.
 */
public record MoveBookCopyCommand(
        Long bookCopyId,
        String newShelfLocation
) {}

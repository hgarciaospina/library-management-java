package com.jikkosoft.library.application.dto.bookcopy;
/**
 * Command to logically delete a Book.
 * (Business rule: the book-copy is not physically deleted,
 * it is marked as deactivated.)
 */

public record DeleteBookCopyCommand(
        Long id
) {}

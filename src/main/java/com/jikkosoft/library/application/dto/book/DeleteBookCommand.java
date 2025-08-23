package com.jikkosoft.library.application.dto.book;

/**
 * Command to logically delete a Book.
 * (Business rule: the book is not physically deleted,
 * it is marked as deactivated.)
 */
public record DeleteBookCommand(
        Long id
) {}


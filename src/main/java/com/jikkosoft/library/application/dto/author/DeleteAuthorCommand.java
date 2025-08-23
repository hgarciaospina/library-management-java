package com.jikkosoft.library.application.dto.author;

/**
 * Command to delete an Author.
 * Only the ID is required to perform the operation.
 */
public record DeleteAuthorCommand(Long id) {}

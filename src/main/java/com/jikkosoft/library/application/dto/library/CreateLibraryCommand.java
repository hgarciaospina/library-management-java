package com.jikkosoft.library.application.dto.library;

/**
 * Command to create a new Library.
 */
public record CreateLibraryCommand(
        String name,
        String address
) {}

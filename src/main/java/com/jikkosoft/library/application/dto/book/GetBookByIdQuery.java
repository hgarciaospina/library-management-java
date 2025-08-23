package com.jikkosoft.library.application.dto.book;

/**
 * Query to retrieve a Book by its ID.
 */
public record GetBookByIdQuery(
        Long id
) {}

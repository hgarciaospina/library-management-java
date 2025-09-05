package com.jikkosoft.library.application.common;

import lombok.Builder;

import java.util.List;

/**
 * Generic response for paginated queries.
 *
 * @param <T> Type of items in the response.
 */
@Builder
public record PagedResponse<T>(
        List<T> items,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean hasNext,
        boolean hasPrevious
) {}

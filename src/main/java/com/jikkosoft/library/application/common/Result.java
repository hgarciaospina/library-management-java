package com.jikkosoft.library.application.common;

import lombok.Builder;

/**
 * Standard result wrapper for commands and queries.
 *
 * @param <T> The type of the data returned (optional).
 */
@Builder
public record Result<T>(
        boolean success,
        String message,
        T data
) {
    public static <T> Result<T> success(T data) {
        return new Result<>(true, null, data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(true, message, data);
    }

    public static <T> Result<T> failure(String message) {
        return new Result<>(false, message, null);
    }
}

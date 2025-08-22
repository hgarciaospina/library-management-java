package com.jikkosoft.library.domain.exception;

/**
 * Custom exception for business rules violations.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}

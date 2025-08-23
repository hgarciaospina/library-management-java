package com.jikkosoft.library.application.dto.user;

import java.util.Set;

/**
 * Read model for user data.
 */
public record UserResponse(
        Long id,
        String email,
        Set<String> roles,
        boolean active
) {}

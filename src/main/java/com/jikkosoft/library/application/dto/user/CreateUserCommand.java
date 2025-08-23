package com.jikkosoft.library.application.dto.user;

import java.util.Set;

/**
 * Command to create a new User with initial roles.
 */
public record CreateUserCommand(
        String email,
        String rawPassword,
        Set<String> roleNames // e.g., ["ADMIN", "NORMAL_USER"]
) {}

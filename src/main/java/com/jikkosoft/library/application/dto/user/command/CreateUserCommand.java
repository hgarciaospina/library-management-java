package com.jikkosoft.library.application.dto.user.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * Command to create a new User.
 *
 * Responsibilities:
 * - Encapsulates all required fields to create a user.
 * - Enforces validation at the boundary layer.
 */
@Data
@Builder
public class CreateUserCommand {

    /** Email address of the user (required). */
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    /** Set of role names to assign to the user (required). */
    @NotBlank(message = "At least one role is required")
    private Set<String> roles;

    /** Indicates whether the user is active. */
    private boolean active;
}

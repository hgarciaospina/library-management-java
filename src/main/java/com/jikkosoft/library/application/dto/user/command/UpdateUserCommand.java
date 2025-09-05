package com.jikkosoft.library.application.dto.user.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * Command to update an existing User.
 *
 * Responsibilities:
 * - Encapsulates editable fields of a user.
 * - Validates input at the boundary.
 */
@Data
@Builder
public class UpdateUserCommand {

    /** Identifier of the user to update (required). */
    @NotNull(message = "User ID is required")
    private Long id;

    /** Email address of the user. */
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    /** Set of role names to assign. */
    private Set<String> roles;

    /** Indicates whether the user is active. */
    private Boolean active;
}

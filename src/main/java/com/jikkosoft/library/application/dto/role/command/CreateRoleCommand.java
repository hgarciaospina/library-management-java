package com.jikkosoft.library.application.dto.role.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.jikkosoft.library.domain.enums.RoleType;

/**
 * Command to create a new Role.
 *
 * Responsibilities:
 * - Encapsulates required fields for role creation.
 * - Enforces validation at the boundary layer.
 */
@Data
@Builder
public class CreateRoleCommand {

    /** Type of the role (required). */
    @NotNull(message = "Role type is required")
    private RoleType roleType;

    /** Optional description (max 200 characters). */
    @Size(max = 200, message = "Description cannot exceed 200 characters")
    private String description;
}

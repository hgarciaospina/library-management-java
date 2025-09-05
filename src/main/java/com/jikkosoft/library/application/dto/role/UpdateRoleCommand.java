package com.jikkosoft.library.application.dto.role;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.jikkosoft.library.domain.enums.RoleType;

/**
 * Command to update an existing Role.
 *
 * Responsibilities:
 * - Encapsulates editable fields of a role.
 * - Ensures validation at the boundary.
 */
@Data
@Builder
public class UpdateRoleCommand {

    /** Identifier of the role to update (required). */
    @NotNull(message = "Role ID is required")
    private Long id;

    /** Role type (optional for update). */
    private RoleType roleType;

    /** Optional description (max 200 characters). */
    @Size(max = 200, message = "Description cannot exceed 200 characters")
    private String description;
}

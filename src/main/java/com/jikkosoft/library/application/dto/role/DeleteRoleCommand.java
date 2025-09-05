package com.jikkosoft.library.application.dto.role;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to logically delete a Role.
 */
@Data
@Builder
public class DeleteRoleCommand {

    /** Identifier of the role to delete (required). */
    @NotNull(message = "Role ID is required")
    private Long id;
}

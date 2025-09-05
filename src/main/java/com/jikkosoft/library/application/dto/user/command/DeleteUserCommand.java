package com.jikkosoft.library.application.dto.user.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to logically delete (soft-delete) a User.
 */
@Data
@Builder
public class DeleteUserCommand {

    /** Identifier of the user to delete (required). */
    @NotNull(message = "User ID is required")
    private Long id;
}

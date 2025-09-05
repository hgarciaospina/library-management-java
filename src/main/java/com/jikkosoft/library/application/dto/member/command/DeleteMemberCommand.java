package com.jikkosoft.library.application.dto.member.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to logically delete (soft-delete) a Member.
 */
@Data
@Builder
public class DeleteMemberCommand {

    /** Identifier of the member to delete (required). */
    @NotNull(message = "Member ID is required")
    private Long id;
}

package com.jikkosoft.library.application.dto.member;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Command to update an existing Member.
 *
 * Responsibilities:
 * - Encapsulates editable fields of a member.
 * - Validates input at the boundary.
 */
@Data
@Builder
public class UpdateMemberCommand {

    /** Identifier of the member to update (required). */
    @NotNull(message = "Member ID is required")
    private Long id;

    /** First name of the member (required, max 50 characters). */
    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    private String firstName;

    /** Last name of the member (required, max 50 characters). */
    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    private String lastName;

    /** Email of the member (required, valid format, max 100 characters). */
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    /** Status of the member (active/inactive). */
    private boolean active;
}

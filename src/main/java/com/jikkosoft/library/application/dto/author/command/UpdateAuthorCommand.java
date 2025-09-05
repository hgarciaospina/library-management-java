package com.jikkosoft.library.application.dto.author.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * Command to update an existing Author.
 *
 * Responsibilities:
 * - Identifies the author by ID.
 * - Provides new values for mutable fields.
 * - Ensures validation at the boundary level using Jakarta Validation.
 */
@Data
@Builder
public class UpdateAuthorCommand {

    @NotNull(message = "Author ID is required")
    private Long id;

    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @Size(max = 50, message = "Nationality must not exceed 50 characters")
    private String nationality;

    @Past(message = "The date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Size(max = 500, message = "Biography must not exceed 500 characters")
    private String biography;

    @Size(max = 200, message = "Website must not exceed 200 characters")
    private String website;

    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @Size(max = 100, message = "Affiliation must not exceed 100 characters")
    private String affiliation;
}

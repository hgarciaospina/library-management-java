package com.jikkosoft.library.application.dto.library.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Command to create a new Library.
 *
 * Responsibilities:
 * - Encapsulates required fields to create a library.
 * - Members and BookCopies are added later via separate commands.
 * - Enforces validation at the boundary using Jakarta Validation.
 * - Follows the same class-based style as other commands (Author, Book, BookCopy, Category).
 */
@Data
@Builder
public class CreateLibraryCommand {

    /** Name of the library (required, max 150 characters). */
    @NotBlank(message = "Library name is required")
    @Size(max = 150, message = "Library name cannot exceed 150 characters")
    private String name;

    /** Address of the library (required, max 250 characters). */
    @NotBlank(message = "Library address is required")
    @Size(max = 250, message = "Library address cannot exceed 250 characters")
    private String address;
}

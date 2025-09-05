package com.jikkosoft.library.application.dto.library.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to delete (soft-delete) a Library.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the library to be deleted.
 * - Ensures the ID is provided and valid.
 * - Soft deletion is handled in the domain/service layer.
 * - Follows the same class-based style as other commands (Author, Book, BookCopy, Category).
 */
@Data
@Builder
public class DeleteLibraryCommand {

    /** Identifier of the library to delete (required). */
    @NotNull(message = "Library ID is required")
    private Long id;
}

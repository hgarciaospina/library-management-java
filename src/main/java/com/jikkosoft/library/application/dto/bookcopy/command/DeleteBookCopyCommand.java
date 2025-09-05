package com.jikkosoft.library.application.dto.bookcopy.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to delete (soft-delete) a BookCopy.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the BookCopy to be logically deleted.
 * - Ensures the identifier is provided and valid.
 */
@Data
@Builder
public class DeleteBookCopyCommand {

    /** Identifier of the BookCopy to be deleted (required). */
    @NotNull(message = "The BookCopy ID is required")
    private Long id;
}

package com.jikkosoft.library.application.dto.author.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to delete (soft-delete) an Author.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the author to be deleted.
 * - Ensures the identifier is provided and valid.
 */
@Data
@Builder
public class DeleteAuthorCommand {

    @NotNull(message = "Author ID is required")
    private Long id;
}

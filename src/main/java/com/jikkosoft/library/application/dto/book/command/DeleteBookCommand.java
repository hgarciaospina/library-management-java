package com.jikkosoft.library.application.dto.book.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to logically delete a Book by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the book to be deleted.
 * - Ensures the identifier is provided and valid.
 */
@Data
@Builder
public class DeleteBookCommand {

    @NotNull(message = "Book ID is required")
    private Long id;
}

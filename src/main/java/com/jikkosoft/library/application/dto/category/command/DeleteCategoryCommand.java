package com.jikkosoft.library.application.dto.category.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Command to delete (soft-delete) a Book Category.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the category to be deleted.
 * - Ensures the identifier is provided and valid.
 * - Follows the same class-based style as other commands (Author, Book).
 */
@Data
@Builder
public class DeleteCategoryCommand {

    /** Identifier of the category to delete (required). */
    @NotNull(message = "Category ID is required")
    private Long id;
}

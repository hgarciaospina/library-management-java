package com.jikkosoft.library.application.dto.category.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Command to update an existing Book Category.
 *
 * Responsibilities:
 * - Encapsulates fields required to update a category.
 * - Ensures validation at the boundary using Jakarta Validation.
 * - Follows the same class-based style as other commands (Author, Book).
 */
@Data
@Builder
public class UpdateCategoryCommand {

    /** Identifier of the category to update (required). */
    @NotNull(message = "Category ID is required")
    private Long id;

    /** Name of the category (required, max 100 characters). */
    @NotBlank(message = "Category name is required")
    @Size(max = 100, message = "Category name cannot exceed 100 characters")
    private String name;

    /** Maximum number of loan days allowed for books in this category (must be positive). */
    @Positive(message = "Maximum loan days must be positive")
    private int maxLoanDays;

    /** Penalty per day for overdue books in this category (must be positive). */
    @Positive(message = "Penalty per day must be positive")
    private int penaltyPerDay;
}

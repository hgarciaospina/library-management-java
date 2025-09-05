package com.jikkosoft.library.application.dto.category;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Command to create a new Book Category.
 *
 * Responsibilities:
 * - Encapsulates required fields to create a category.
 * - Enforces validation at the boundary level using Jakarta Validation.
 * - Follows the same class-based style as CreateAuthorCommand and CreateBookCommand.
 */
@Data
@Builder
public class CreateCategoryCommand {

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

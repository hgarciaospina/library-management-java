package com.jikkosoft.library.application.dto.book;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * Command to update an existing Book.
 *
 * Responsibilities:
 * - Identifies the book by its ID.
 * - Provides new values for mutable fields.
 * - Enforces input validation using Jakarta Validation.
 */
@Data
@Builder
public class UpdateBookCommand {

    @NotNull(message = "The book ID is required")
    private Long id;

    @NotBlank
    @Size(max = 20, message = "ISBN cannot exceed 20 characters")
    private String isbn;

    @NotBlank
    @Size(max = 200, message = "Title cannot exceed 200 characters")
    private String title;

    @Min(value = 0, message = "Publication year must be a valid positive number")
    private int publicationYear;

    private List<@NotNull Long> authorIds;

    @NotNull(message = "Category is required")
    private Long categoryId;
}

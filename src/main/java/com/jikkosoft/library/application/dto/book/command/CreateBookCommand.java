package com.jikkosoft.library.application.dto.book.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

import java.util.List;

/**
 * Command to create a new Book.
 *
 * Responsibilities:
 * - Encapsulates the input fields required to create a Book entity.
 * - Ensures validation at the boundary level using Jakarta Validation.
 * - Represents an input action, not a persisted state.
 */
@Data
@Builder
public class CreateBookCommand {

    @NotBlank(message = "ISBN is required")
    @Size(max = 20, message = "ISBN must not exceed 20 characters")
    private String isbn;

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must not exceed 200 characters")
    private String title;

    @NotNull(message = "Publication year is required")
    @Min(value = 1400, message = "Publication year must not be earlier than 1400")
    @Max(value = 2100, message = "Publication year must not be later than 2100")
    private Integer publicationYear;

    @NotEmpty(message = "At least one author must be specified")
    private List<Long> authorIds;

    @NotNull(message = "Category ID is required")
    private Long categoryId;
}

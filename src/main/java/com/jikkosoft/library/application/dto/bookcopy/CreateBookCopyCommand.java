package com.jikkosoft.library.application.dto.bookcopy;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Command to create a new BookCopy.
 *
 * Responsibilities:
 * - Encapsulates required fields to create a new physical copy of a book.
 * - Ensures validation at the boundary of the application layer.
 */
@Data
@Builder
public class CreateBookCopyCommand {
    @NotNull
    private Long bookId;

    @NotNull
    private Long libraryId;

    @Positive
    private Integer copyNumber;

    @Size(min = 3, max = 50)
    private String barcode;

    @NotNull
    private String status; // AVAILABLE, LOANED, RESERVED, DAMAGED

    @Size(max = 100)
    private String shelfLocation;
}

package com.jikkosoft.library.application.dto.bookcopy.command;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Command to update an existing BookCopy.
 *
 * Responsibilities:
 * - Encapsulates fields required to update a BookCopy.
 * - Allows modification of status, shelf location, and related metadata.
 * - Enforces validation at the boundary level using Jakarta Validation.
 */
@Data
@Builder
public class UpdateBookCopyCommand {

    /** Identifier of the BookCopy to be updated (required). */
    @NotNull(message = "BookCopy ID is required")
    private Long id;

    /** Identifier of the associated Book (required). */
    @NotNull(message = "Book ID is required")
    private Long bookId;

    /** Identifier of the associated Library (required). */
    @NotNull(message = "Library ID is required")
    private Long libraryId;

    /** Sequential number of the copy (must be positive). */
    @NotNull(message = "Copy number is required")
    @Positive(message = "Copy number must be positive")
    private Integer copyNumber;

    /** Unique barcode identifier. Must be between 3 and 50 characters. */
    @Size(min = 3, max = 50, message = "Barcode must be between 3 and 50 characters")
    private String barcode;

    /** Status of the copy (e.g., AVAILABLE, LOANED, RESERVED, LOST, DAMAGED). */
    @NotNull(message = "Status is required")
    @Size(max = 20, message = "Status cannot exceed 20 characters")
    private String status;

    /** Physical shelf location of the copy (optional, max 100 characters). */
    @Size(max = 100, message = "Shelf location cannot exceed 100 characters")
    private String shelfLocation;
}

package com.jikkosoft.library.application.dto.library;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * Command to update an existing Library.
 *
 * Responsibilities:
 * - Encapsulates the editable fields of a Library (name and address).
 * - Ensures validation at the boundary level using Jakarta Validation.
 * - Immutable-like behavior via Lombok @Data + @Builder.
 */
@Data
@Builder
public class UpdateLibraryCommand {

    /** Identifier of the library to be updated (required). */
    @NotNull(message = "Library ID is required")
    private Long id;

    /** Name of the library (required, max 100 characters). */
    @NotBlank(message = "Library name is required")
    @Size(max = 100, message = "Library name cannot exceed 100 characters")
    private String name;

    /** Physical address of the library (required, max 200 characters). */
    @NotBlank(message = "Library address is required")
    @Size(max = 200, message = "Library address cannot exceed 200 characters")
    private String address;
}

package com.jikkosoft.library.application.dto.author;

import java.time.LocalDate;

/**
 * Command to update an existing Author.
 * The ID must be provided to identify which author will be updated.
 */
public record UpdateAuthorCommand(
        Long id,
        String firstName,
        String lastName,
        String nationality,
        LocalDate dateOfBirth,
        String biography,
        String website,
        String email,
        String affiliation
) {}

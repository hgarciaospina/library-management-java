package com.jikkosoft.library.application.dto.author;

import java.time.LocalDate;

/**
 * Command to create a new Author.
 * All required fields must be provided.
 */
public record CreateAuthorCommand(
        String firstName,
        String lastName,
        String nationality,
        LocalDate dateOfBirth,
        String biography,
        String website,
        String email,
        String affiliation
) {}

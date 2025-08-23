package com.jikkosoft.library.application.dto.author;

import java.time.LocalDate;

/**
 * Data Transfer Object representing an Author.
 * Used to send Author information to clients without exposing the domain model directly.
 */
public record AuthorDto(
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

package com.jikkosoft.library.application.dto.author.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for Author.
 *
 * Responsibilities:
 * - Provides a safe, immutable representation of an Author for read operations.
 * - Exposes core details such as name, nationality, and biography.
 * - Includes audit fields inherited from BaseEntity (createdAt, updatedAt, deletedAt).
 *
 * Notes:
 * - Fields such as biography, website, and affiliation may be optional.
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
        String affiliation,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
) {}

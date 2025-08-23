package com.jikkosoft.library.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Domain model representing an Author of publications.
 *
 * Responsibilities:
 * - Identifies an author by ID, name, and optional metadata.
 * - Stores biographical details (date of birth, nationality).
 * - Stores professional details such as affiliation and website.
 *
 * Invariants:
 * - firstName and lastName must not be null or blank.
 * - email (if present) should be unique in the system (enforced externally).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    /** Unique identifier of the author. */
    private Long id;

    /** Author's first name. */
    private String firstName;

    /** Author's last name. */
    private String lastName;

    /** Author's nationality (e.g., "Colombian", "American"). */
    private String nationality;

    /** Author's date of birth (optional). */
    private LocalDate dateOfBirth;

    /** Short biography or description of the author. */
    private String biography;

    /** Author's official website or profile link. */
    private String website;

    /** Contact email of the author (optional). */
    private String email;

    /** Institutional or professional affiliation (e.g., university, publisher). */
    private String affiliation;
}

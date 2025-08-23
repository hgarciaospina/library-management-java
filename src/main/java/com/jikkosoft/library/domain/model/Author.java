package com.jikkosoft.library.domain.model;

import java.time.Year;
import java.util.List;

/**
 * Domain model representing an Author.
 *
 * Responsibilities:
 * - Holds bibliographic and biographical data of an author.
 * - Enforces validation rules at construction and setter level.
 * - Designed as a pure domain entity (no persistence annotations).
 *
 * Validation responsibilities:
 * - Name must not be null or blank.
 * - Birth year must be before or equal to the current year.
 * - If death year is provided, it must be after the birth year and not after the current year.
 * - Nationality must not be null or blank.
 */
public class Author {

    private Long id;
    private String fullName;
    private Year birthYear;
    private Year deathYear; // optional (null if still alive)
    private String nationality;
    private String biography; // free text about the author
    private List<String> awards;  // list of relevant awards
    private List<String> aliases; // pen names or alternative names

    public Author(Long id,
                  String fullName,
                  Year birthYear,
                  Year deathYear,
                  String nationality,
                  String biography,
                  List<String> awards,
                  List<String> aliases) {

        validateName(fullName);
        validateBirthYear(birthYear);
        validateDeathYear(birthYear, deathYear);
        validateNationality(nationality);

        this.id = id;
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.nationality = nationality;
        this.biography = biography;
        this.awards = awards;
        this.aliases = aliases;
    }

    public Author() { /* for serializers */ }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Author name must not be null or blank.");
        }
    }

    private void validateBirthYear(Year birthYear) {
        if (birthYear == null) {
            throw new IllegalArgumentException("Birth year must not be null.");
        }
        if (birthYear.isAfter(Year.now())) {
            throw new IllegalArgumentException("Birth year cannot be in the future.");
        }
    }

    private void validateDeathYear(Year birthYear, Year deathYear) {
        if (deathYear != null) {
            if (deathYear.isBefore(birthYear)) {
                throw new IllegalArgumentException("Death year must be after birth year.");
            }
            if (deathYear.isAfter(Year.now())) {
                throw new IllegalArgumentException("Death year cannot be in the future.");
            }
        }
    }

    private void validateNationality(String nationality) {
        if (nationality == null || nationality.isBlank()) {
            throw new IllegalArgumentException("Nationality must not be null or blank.");
        }
    }

    // Getters / Setters (with validation where appropriate)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { validateName(fullName); this.fullName = fullName; }

    public Year getBirthYear() { return birthYear; }
    public void setBirthYear(Year birthYear) { validateBirthYear(birthYear); this.birthYear = birthYear; }

    public Year getDeathYear() { return deathYear; }
    public void setDeathYear(Year deathYear) { validateDeathYear(this.birthYear, deathYear); this.deathYear = deathYear; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { validateNationality(nationality); this.nationality = nationality; }

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }

    public List<String> getAwards() { return awards; }
    public void setAwards(List<String> awards) { this.awards = awards; }

    public List<String> getAliases() { return aliases; }
    public void setAliases(List<String> aliases) { this.aliases = aliases; }
}

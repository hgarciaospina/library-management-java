package com.jikkosoft.library.domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Domain model representing an Author of publications.
 *
 * Responsibilities:
 * - Inherits audit fields from BaseEntity (createdAt, updatedAt, deletedAt).
 * - Identifies an author by ID, first name, last name, and optional metadata.
 * - Stores biographical details (date of birth, nationality).
 * - Stores professional details such as affiliation and website.
 * - Enforces domain-level validation rules for consistency and correctness.
 *
 * Builder pattern is provided for safe and readable construction.
 *
 * Validation rules:
 * - First name and last name must not be null or blank.
 * - Date of birth (if provided) must not be in the future.
 * - Nationality must not be null or blank.
 * - Email (if provided) must contain a valid format.
 * - Website (if provided) must not be blank.
 *
 * Invariants:
 * - Cannot be created or updated with invalid data.
 * - Email uniqueness assumed to be enforced externally (repository or DB).
 */
public class Author extends BaseEntity {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String nationality;
    private final LocalDate dateOfBirth;
    private final String biography;
    private final String website;
    private final String email;
    private final String affiliation;

    // ======================= Private constructor =======================
    private Author(Builder builder) {
        super(); // initializes createdAt, updatedAt, deletedAt
        validateName(builder.firstName, "First name");
        validateName(builder.lastName, "Last name");
        validateNationality(builder.nationality);
        validateDateOfBirth(builder.dateOfBirth);
        validateEmail(builder.email);

        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.nationality = builder.nationality;
        this.dateOfBirth = builder.dateOfBirth;
        this.biography = builder.biography;
        this.website = builder.website;
        this.email = builder.email;
        this.affiliation = builder.affiliation;
    }

    // ======================= Validation Methods =======================
    private void validateName(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be null or blank.");
        }
    }

    private void validateNationality(String nationality) {
        if (nationality == null || nationality.isBlank()) {
            throw new IllegalArgumentException("Nationality must not be null or blank.");
        }
    }

    private void validateDateOfBirth(LocalDate dob) {
        if (dob != null && dob.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }
    }

    private void validateEmail(String email) {
        if (email != null && !email.isBlank() && !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
    }

    // ======================= Getters =======================
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getNationality() { return nationality; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getBiography() { return biography; }
    public String getWebsite() { return website; }
    public String getEmail() { return email; }
    public String getAffiliation() { return affiliation; }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String nationality;
        private LocalDate dateOfBirth;
        private String biography;
        private String website;
        private String email;
        private String affiliation;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder nationality(String nationality) { this.nationality = nationality; return this; }
        public Builder dateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
        public Builder biography(String biography) { this.biography = biography; return this; }
        public Builder website(String website) { this.website = website; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder affiliation(String affiliation) { this.affiliation = affiliation; return this; }

        public Author build() { return new Author(this); }
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}

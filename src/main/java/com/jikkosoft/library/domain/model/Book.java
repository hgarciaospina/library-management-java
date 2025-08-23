package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.vo.ISBN;

import java.time.Year;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Domain model representing a Book (pure domain, no persistence annotations).
 * Holds bibliographic data and enforces core invariants at construction time.
 *
 * Validation responsibilities:
 * - Title must not be null or blank.
 * - Publication year must be between 1000 and the current year.
 * - ISBN is validated according to the publication year via the ISBN value object.
 * - Category must be provided (defines loan/policy parameters for the book).
 * - Must have at least one author.
 */
public class Book {

    private Long id;
    private ISBN isbn;
    private String title;
    private List<Author> authors; // ✅ Multiple authors
    private int publicationYear;
    private Category category;

    /**
     * Creates a new Book instance, enforcing core validation rules.
     */
    public Book(Long id, String isbnValue, String title, List<Author> authors, int publicationYear, Category category) {
        validateTitle(title);
        validatePublicationYear(publicationYear);
        validateCategory(category);
        validateAuthors(authors);

        this.id = id;
        this.isbn = new ISBN(isbnValue, publicationYear);
        this.title = title;
        this.authors = List.copyOf(authors); // defensive copy ✅
        this.publicationYear = publicationYear;
        this.category = category;
    }

    public Book() {
        // Empty constructor for frameworks/serialization
    }

    // --- Validation helpers ---

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Book title must not be null or blank.");
        }
    }

    private void validatePublicationYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1000 || year > currentYear) {
            throw new IllegalArgumentException("Publication year must be between 1000 and " + currentYear);
        }
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Book category must not be null.");
        }
    }

    private void validateAuthors(List<Author> authors) {
        if (authors == null || authors.isEmpty()) {
            throw new IllegalArgumentException("A book must have at least one author.");
        }
        if (authors.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Authors list must not contain null elements.");
        }
    }

    // --- Getters and setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ISBN getIsbn() { return isbn; }
    public void setIsbn(String isbnValue, int publicationYear) {
        validatePublicationYear(publicationYear);
        this.isbn = new ISBN(isbnValue, publicationYear);
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public List<Author> getAuthors() {
        return Collections.unmodifiableList(authors); // ✅ defensive read-only
    }

    public void setAuthors(List<Author> authors) {
        validateAuthors(authors);
        this.authors = List.copyOf(authors); // ✅ defensive copy
    }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) {
        validatePublicationYear(publicationYear);
        this.publicationYear = publicationYear;
    }

    public Category getCategory() { return category; }
    public void setCategory(Category category) {
        validateCategory(category);
        this.category = category;
    }
}

package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.vo.ISBN;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Domain model representing a Book (pure domain, no persistence annotations).
 * Holds bibliographic data and enforces core invariants at construction time.
 *
 * Validation responsibilities:
 * - Title must not be null or blank.
 * - Publication year must be between 1000 and the current year.
 * - At least one author must be provided.
 * - ISBN is validated according to the publication year via the ISBN value object.
 * - Category must be provided (defines loan/policy parameters for the book).
 */
public class Book {

    private Long id;
    private ISBN isbn;
    private String title;
    private final List<Author> authors = new ArrayList<>();
    private int publicationYear;
    private Category category;

    /**
     * Creates a new Book instance, enforcing core validation rules.
     */
    public Book(Long id,
                String isbnValue,
                String title,
                List<Author> authors,
                int publicationYear,
                Category category) {

        validateTitle(title);
        validatePublicationYear(publicationYear);
        validateAuthors(authors);
        validateCategory(category);

        this.id = id;
        this.isbn = new ISBN(isbnValue, publicationYear);
        this.title = title;
        this.authors.addAll(authors);
        this.publicationYear = publicationYear;
        this.category = category;
    }

    public Book() { /* for serializers/frameworks */ }

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

    private void validateAuthors(List<Author> authors) {
        if (authors == null || authors.isEmpty()) {
            throw new IllegalArgumentException("Book must have at least one author.");
        }
        if (authors.stream().anyMatch(a -> a == null)) {
            throw new IllegalArgumentException("Authors list must not contain null elements.");
        }
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Book category must not be null.");
        }
    }

    // --- Getters and setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ISBN getIsbn() { return isbn; }
    public void setIsbn(String isbnValue, int publicationYear) {
        validatePublicationYear(publicationYear);
        this.isbn = new ISBN(isbnValue, publicationYear);
        this.publicationYear = publicationYear; // keep year in sync if changed with ISBN
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { validateTitle(title); this.title = title; }

    public List<Author> getAuthors() { return Collections.unmodifiableList(authors); }
    public void replaceAuthors(List<Author> newAuthors) {
        validateAuthors(newAuthors);
        this.authors.clear();
        this.authors.addAll(newAuthors);
    }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) {
        validatePublicationYear(publicationYear);
        // When changing the year, the ISBN length rule could change. Keep ISBN consistent:
        this.isbn = new ISBN(this.isbn.getValue(), publicationYear);
        this.publicationYear = publicationYear;
    }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { validateCategory(category); this.category = category; }
}

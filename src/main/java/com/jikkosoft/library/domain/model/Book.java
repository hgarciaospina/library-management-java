package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.vo.ISBN;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Domain model representing a Book.
 *
 * Responsibilities:
 * - Inherits audit fields from BaseEntity.
 * - Holds bibliographic data and enforces invariants at construction.
 * - Supports multiple authors and category association.
 * - ISBN validated according to publication year via ISBN value object.
 *
 * Builder pattern allows safe construction and readability.
 *
 * Validation rules:
 * - Title must not be null or blank.
 * - Publication year must be between 1000 and current year.
 * - At least one author must be provided.
 * - Category must not be null.
 */
public class Book extends BaseEntity {

    private final Long id;
    private ISBN isbn;
    private String title;
    private final List<Author> authors = new ArrayList<>();
    private int publicationYear;
    private Category category;

    // ======================= Private constructor =======================
    private Book(Builder builder) {
        super();
        validateTitle(builder.title);
        validatePublicationYear(builder.publicationYear);
        validateAuthors(builder.authors);
        validateCategory(builder.category);

        this.id = builder.id;
        this.title = builder.title;
        this.publicationYear = builder.publicationYear;
        this.isbn = new ISBN(builder.isbnValue, builder.publicationYear);
        this.category = builder.category;
        this.authors.addAll(builder.authors);
    }

    // ======================= Validation helpers =======================
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

    // ======================= Getters and setters =======================
    public Long getId() { return id; }
    public ISBN getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public List<Author> getAuthors() { return Collections.unmodifiableList(authors); }
    public int getPublicationYear() { return publicationYear; }
    public Category getCategory() { return category; }

    public void setTitle(String title) { validateTitle(title); this.title = title; }

    public void replaceAuthors(List<Author> newAuthors) {
        validateAuthors(newAuthors);
        this.authors.clear();
        this.authors.addAll(newAuthors);
    }

    public void setPublicationYear(int publicationYear) {
        validatePublicationYear(publicationYear);
        this.publicationYear = publicationYear;
        this.isbn = new ISBN(this.isbn.getValue(), publicationYear); // keep ISBN consistent
    }

    public void setCategory(Category category) { validateCategory(category); this.category = category; }

    public void setIsbn(String isbnValue) { this.isbn = new ISBN(isbnValue, this.publicationYear); }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private String isbnValue;
        private String title;
        private List<Author> authors = new ArrayList<>();
        private int publicationYear;
        private Category category;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder isbnValue(String isbnValue) { this.isbnValue = isbnValue; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder authors(List<Author> authors) { this.authors = new ArrayList<>(authors); return this; }
        public Builder publicationYear(int year) { this.publicationYear = year; return this; }
        public Builder category(Category category) { this.category = category; return this; }

        public Book build() { return new Book(this); }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", isbn=" + isbn.getValue() +
                ", authors=" + authors +
                ", category=" + (category != null ? category.getName() : null) +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}

package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.vo.CopyNumber;
import com.jikkosoft.library.domain.enums.BookStatus;
import java.util.Objects;

/**
 * Domain model representing a physical copy of a Book in a Library.
 *
 * Responsibilities:
 * - Tracks immutable references to Book, Library, CopyNumber, and Barcode.
 * - Supports mutable status and shelf location.
 * - Integrates with audit tracking via BaseEntity.
 *
 * Validation rules:
 * - book, library, copyNumber, and barcode cannot be null.
 * - shelfLocation cannot be null or blank.
 * - Status defaults to AVAILABLE at creation.
 *
 * Notes:
 * - Builder pattern is used for clean and safe construction.
 * - Immutable fields cannot be changed after creation.
 * - Supports integration with AuditLog for before/after snapshots.
 */
public class BookCopy extends BaseEntity {

    private final Long id;
    private final Book book;
    private final Library library;
    private final CopyNumber copyNumber;
    private final String barcode;
    private BookStatus status;
    private String shelfLocation;

    // ======================= Private constructor =======================
    private BookCopy(Builder builder) {
        super();
        Objects.requireNonNull(builder.book, "Book must not be null.");
        Objects.requireNonNull(builder.library, "Library must not be null.");
        Objects.requireNonNull(builder.copyNumber, "CopyNumber must not be null.");
        Objects.requireNonNull(builder.barcode, "Barcode must not be null.");
        if (builder.shelfLocation == null || builder.shelfLocation.isBlank()) {
            throw new IllegalArgumentException("Shelf location must not be null or blank.");
        }

        this.id = builder.id;
        this.book = builder.book;
        this.library = builder.library;
        this.copyNumber = builder.copyNumber;
        this.barcode = builder.barcode;
        this.shelfLocation = builder.shelfLocation;
        this.status = builder.status != null ? builder.status : BookStatus.AVAILABLE;
    }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private Book book;
        private Library library;
        private CopyNumber copyNumber;
        private String barcode;
        private String shelfLocation;
        private BookStatus status;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder book(Book book) { this.book = book; return this; }
        public Builder library(Library library) { this.library = library; return this; }
        public Builder copyNumber(CopyNumber copyNumber) { this.copyNumber = copyNumber; return this; }
        public Builder barcode(String barcode) { this.barcode = barcode; return this; }
        public Builder shelfLocation(String shelfLocation) { this.shelfLocation = shelfLocation; return this; }
        public Builder status(BookStatus status) { this.status = status; return this; }

        public BookCopy build() { return new BookCopy(this); }
    }

    // ======================= Getters =======================
    public Long getId() { return id; }
    public Book getBook() { return book; }
    public Library getLibrary() { return library; }
    public CopyNumber getCopyNumber() { return copyNumber; }
    public String getBarcode() { return barcode; }
    public BookStatus getStatus() { return status; }
    public String getShelfLocation() { return shelfLocation; }

    // ======================= Mutators =======================
    public void changeStatus(BookStatus newStatus) {
        Objects.requireNonNull(newStatus, "Status must not be null.");
        if (this.status == BookStatus.DEACTIVATED) {
            throw new IllegalStateException("A deactivated copy cannot change its status.");
        }
        this.status = newStatus;
        markUpdated();
    }

    public void updateShelfLocation(String newLocation) {
        if (newLocation == null || newLocation.isBlank()) {
            throw new IllegalArgumentException("Shelf location must not be null or blank.");
        }
        this.shelfLocation = newLocation;
        markUpdated();
    }

    // ======================= Equals & HashCode =======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCopy)) return false;
        BookCopy copy = (BookCopy) o;
        return Objects.equals(book, copy.book) &&
                Objects.equals(library, copy.library) &&
                Objects.equals(copyNumber, copy.copyNumber) &&
                Objects.equals(barcode, copy.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, library, copyNumber, barcode);
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "id=" + id +
                ", book=" + (book != null ? book.getTitle() : null) +
                ", library=" + (library != null ? library.getName() : null) +
                ", copyNumber=" + copyNumber +
                ", barcode='" + barcode + '\'' +
                ", status=" + status +
                ", shelfLocation='" + shelfLocation + '\'' +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }
}

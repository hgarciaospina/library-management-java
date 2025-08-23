package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.BookStatus;
import com.jikkosoft.library.domain.vo.CopyNumber;

import java.util.Objects;

/**
 * Represents a physical copy of a book in the library collection.
 * Each copy is uniquely identified by:
 * - The owning library.
 * - The parent book.
 * - Its copy number.
 *
 * Domain invariants:
 * - A copy must always be associated with a valid book and library.
 * - Copy number cannot be null (uniqueness enforced externally).
 * - Shelf location cannot be null or blank.
 * - Status defaults to AVAILABLE at creation.
 *
 * Domain queries:
 * - isAvailableForLoan(): only AVAILABLE qualifies.
 * - isAvailableForReservation(): only AVAILABLE qualifies.
 *
 * Mutability:
 * - Status and shelf location can change during the lifecycle of the copy
 *   following allowed transitions:
 *   AVAILABLE -> ON_LOAN | DAMAGED | LOST | DEACTIVATED
 *   ON_LOAN   -> AVAILABLE (upon return)
 *   DAMAGED   -> DEACTIVATED (optional policy) or remain DAMAGED
 *   LOST      -> DEACTIVATED (optional policy) or remain LOST
 *   DEACTIVATED -> (no transitions out)
 */
public class BookCopy {

    private final Long id;
    private final Book book;
    private final Library library;
    private final CopyNumber copyNumber;
    private BookStatus status;
    private String shelfLocation;

    public BookCopy(Long id, Book book, Library library, CopyNumber copyNumber, String shelfLocation) {
        if (book == null) throw new IllegalArgumentException("Book must not be null.");
        if (library == null) throw new IllegalArgumentException("Library must not be null.");
        if (copyNumber == null) throw new IllegalArgumentException("CopyNumber must not be null.");
        if (shelfLocation == null || shelfLocation.isBlank()) throw new IllegalArgumentException("Shelf location must not be null or blank.");

        this.id = id;
        this.book = book;
        this.library = library;
        this.copyNumber = copyNumber;
        this.shelfLocation = shelfLocation.trim();
        this.status = BookStatus.AVAILABLE;
    }

    // --- Queries (functional-friendly) ---
    /** Indicates the copy is eligible for loan (AVAILABLE only). */
    public boolean isAvailableForLoan() { return this.status == BookStatus.AVAILABLE; }

    /** Indicates the copy is eligible for reservation (AVAILABLE only). */
    public boolean isAvailableForReservation() { return this.status == BookStatus.AVAILABLE; }

    // --- Getters ---
    public Long getId() { return id; }
    public Book getBook() { return book; }
    public Library getLibrary() { return library; }
    public CopyNumber getCopyNumber() { return copyNumber; }
    public BookStatus getStatus() { return status; }
    public String getShelfLocation() { return shelfLocation; }

    // --- Mutators with guarded transitions ---
    /**
     * Changes the status of the copy, enforcing valid state transitions.
     *
     * @param newStatus New status to assign (must not be null).
     */
    public void changeStatus(BookStatus newStatus) {
        if (newStatus == null) throw new IllegalArgumentException("Status must not be null.");
        if (this.status == BookStatus.DEACTIVATED) {
            throw new IllegalStateException("A deactivated copy cannot change its status.");
        }
        if (this.status == BookStatus.ON_LOAN && newStatus == BookStatus.DAMAGED) {
            // This is allowed if damage is discovered during/after a loan; returning the copy will keep it DAMAGED.
            this.status = BookStatus.DAMAGED;
            return;
        }
        // Allowed transitions matrix (conservative):
        switch (this.status) {
            case AVAILABLE:
                if (newStatus == BookStatus.ON_LOAN || newStatus == BookStatus.DAMAGED
                        || newStatus == BookStatus.LOST || newStatus == BookStatus.DEACTIVATED) {
                    this.status = newStatus;
                } else {
                    throw new IllegalStateException("Invalid transition from AVAILABLE to " + newStatus);
                }
                break;
            case ON_LOAN:
                if (newStatus == BookStatus.AVAILABLE || newStatus == BookStatus.LOST || newStatus == BookStatus.DAMAGED) {
                    this.status = newStatus;
                } else {
                    throw new IllegalStateException("Invalid transition from ON_LOAN to " + newStatus);
                }
                break;
            case DAMAGED:
            case LOST:
                if (newStatus == BookStatus.DEACTIVATED) {
                    this.status = newStatus;
                } else {
                    throw new IllegalStateException("Invalid transition from " + this.status + " to " + newStatus);
                }
                break;
            default:
                // DEACTIVATED handled above
                throw new IllegalStateException("Unhandled current status " + this.status);
        }
    }

    /**
     * Updates the shelf location of this copy.
     * @param newLocation New shelf location (not null/blank).
     */
    public void updateShelfLocation(String newLocation) {
        if (newLocation == null || newLocation.isBlank()) {
            throw new IllegalArgumentException("Shelf location must not be null or blank.");
        }
        this.shelfLocation = newLocation.trim();
    }

    // Equality based on Library + Book + CopyNumber (business key)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCopy)) return false;
        BookCopy other = (BookCopy) o;
        return Objects.equals(library, other.library)
                && Objects.equals(book, other.book)
                && Objects.equals(copyNumber, other.copyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(library, book, copyNumber);
    }
}

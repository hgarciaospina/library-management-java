package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.vo.CopyNumber;
import com.jikkosoft.library.domain.enums.BookStatus;

/**
 * Represents a physical copy of a book in a library.
 * Tracks status, inventory, and location.
 */
public class BookCopy {

    private final Long id;
    private final Book book;
    private final Library library;
    private final CopyNumber copyNumber;
    private BookStatus status;
    private String shelfLocation;

    public BookCopy(Long id, Book book, Library library, CopyNumber copyNumber, String shelfLocation) {
        this.id = id;
        this.book = book;
        this.library = library;
        this.copyNumber = copyNumber;
        this.status = BookStatus.AVAILABLE;
        this.shelfLocation = shelfLocation;
    }

    public Long getId() { return id; }
    public Book getBook() { return book; }
    public Library getLibrary() { return library; }
    public CopyNumber getCopyNumber() { return copyNumber; }
    public BookStatus getStatus() { return status; }
    public String getShelfLocation() { return shelfLocation; }

    public void setStatus(BookStatus status) { this.status = status; }
    public void setShelfLocation(String shelfLocation) { this.shelfLocation = shelfLocation; }
}

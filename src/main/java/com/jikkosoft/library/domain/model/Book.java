package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.vo.ISBN;
import com.jikkosoft.library.domain.vo.BookTitle;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a book.
 * A book can have multiple authors and multiple copies in different libraries.
 */
public class Book {

    private final Long id;
    private final ISBN isbn;
    private final BookTitle title;
    private final Set<String> authors = new HashSet<>();
    private Category category;
    private int maxLoanDays;

    public Book(Long id, ISBN isbn, BookTitle title, int maxLoanDays) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public Long getId() { return id; }
    public ISBN getIsbn() { return isbn; }
    public BookTitle getTitle() { return title; }
    public Set<String> getAuthors() { return authors; }
    public int getMaxLoanDays() { return maxLoanDays; }

    public void addAuthor(String author) {
        authors.add(author);
    }
    public void setMaxLoanDays(int maxLoanDays) { this.maxLoanDays = maxLoanDays; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}

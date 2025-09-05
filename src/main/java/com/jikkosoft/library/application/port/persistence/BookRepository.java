package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.model.Book;
import com.jikkosoft.library.application.common.PagedResponse;

import java.util.Optional;

/**
 * Port for persisting and querying Book aggregates.
 *
 * Responsibilities:
 * - Persist Book entities.
 * - Retrieve books by ID, ISBN, or title search.
 * - Provide logical deletion support.
 * - Support paginated retrieval of books.
 */
public interface BookRepository {

    /**
     * Retrieves a Book by its unique identifier.
     *
     * @param id unique identifier of the book
     * @return Optional containing the found book or empty if not found
     */
    Optional<Book> findById(Long id);

    /**
     * Retrieves a Book by its ISBN code.
     *
     * @param isbnRaw ISBN string of the book
     * @return Optional containing the found book or empty if not found
     */
    Optional<Book> findByIsbn(String isbnRaw);

    /**
     * Saves a Book entity.
     *
     * @param book entity to persist
     * @return persisted Book entity with ID and timestamps populated
     */
    Book save(Book book);

    /**
     * Retrieves books with titles matching the given text (case-insensitive) in a paginated form.
     *
     * @param text text to search in book titles
     * @param page zero-based page index
     * @param size number of items per page
     * @return paginated response of books matching the title search
     */
    PagedResponse<Book> findByTitleLike(String text, int page, int size);

    /**
     * Marks a Book as logically deleted.
     *
     * @param id unique identifier of the book to delete
     */
    void logicalDeleteById(Long id);

    /**
     * Retrieves all books in a paginated form.
     *
     * @param page zero-based page index
     * @param size number of items per page
     * @return paginated response of all books
     */
    PagedResponse<Book> findAll(int page, int size);
}

package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.model.Book;
import java.util.List;
import java.util.Optional;

/**
 * Port for persisting and querying Book aggregates.
 */
public interface BookRepository {
    Optional<Book> findById(Long id);
    Optional<Book> findByIsbn(String isbnRaw);
    Book save(Book book);
    List<Book> findByTitleLike(String text);
    void logicalDeleteById(Long id); // Implemented as a soft-delete flag in persistence layer
}

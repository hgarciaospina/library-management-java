package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.enums.BookStatus;
import com.jikkosoft.library.domain.model.BookCopy;

import java.util.List;
import java.util.Optional;

/**
 * Port for BookCopy persistence and queries required by use cases.
 */
public interface BookCopyRepository {
    Optional<BookCopy> findById(Long id);

    /**
     * Returns all copies of a given book in a given library filtered by status.
     */
    List<BookCopy> findByBookIdAndLibraryIdAndStatus(Long bookId, Long libraryId, BookStatus status);

    /**
     * Returns all copies for a book (any status) to compute inventory totals.
     */
    List<BookCopy> findByBookId(Long bookId);

    BookCopy save(BookCopy copy);
}

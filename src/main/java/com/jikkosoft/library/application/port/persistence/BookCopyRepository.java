package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.enums.BookStatus;
import com.jikkosoft.library.domain.model.BookCopy;

import java.util.List;
import java.util.Optional;

/**
 * Port interface for BookCopy persistence with pagination support.
 *
 * Responsibilities:
 * - Provides CRUD operations for BookCopy entities.
 * - Supports queries filtered by book, library, and status.
 * - Supports paginated retrieval of results.
 *
 * Notes:
 * - Implementations are responsible for actual storage (DB, memory, etc.).
 * - Soft delete handling should be implemented if needed.
 */
public interface BookCopyRepository {

    /**
     * Retrieves a BookCopy by its unique identifier.
     *
     * @param id unique identifier of the BookCopy
     * @return Optional containing the BookCopy if found, otherwise empty
     */
    Optional<BookCopy> findById(Long id);

    /**
     * Returns paginated copies of a specific book in a given library filtered by status.
     *
     * @param bookId    unique identifier of the Book
     * @param libraryId unique identifier of the Library
     * @param status    status of the copies to filter (e.g., AVAILABLE, BORROWED)
     * @param page      page number starting from 0
     * @param size      number of items per page
     * @return PageResult containing BookCopy entities matching the criteria and pagination info
     */
    PageResult<BookCopy> findByBookIdAndLibraryIdAndStatus(Long bookId, Long libraryId, BookStatus status, int page, int size);

    /**
     * Returns paginated copies of a specific book, regardless of their status.
     *
     * @param bookId unique identifier of the Book
     * @param page   page number starting from 0
     * @param size   number of items per page
     * @return PageResult containing all BookCopy entities for the book
     */
    PageResult<BookCopy> findByBookId(Long bookId, int page, int size);

    /**
     * Saves or updates a BookCopy entity.
     *
     * @param copy the BookCopy entity to persist
     * @return the persisted BookCopy entity with ID populated
     */
    BookCopy save(BookCopy copy);

    /**
     * Marks a BookCopy as logically deleted.
     *
     * @param copy the BookCopy entity to delete
     */
    default void delete(BookCopy copy) {
        throw new UnsupportedOperationException("Delete operation not implemented");
    }

    /**
     * Returns paginated copies for a book with a specific status.
     *
     * @param bookId unique identifier of the Book
     * @param status status to filter by
     * @param page   page number starting from 0
     * @param size   number of items per page
     * @return PageResult containing BookCopy entities matching bookId and status
     */
    default PageResult<BookCopy> findByBookIdAndStatus(Long bookId, BookStatus status, int page, int size) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Returns paginated copies in a specific library.
     *
     * @param libraryId unique identifier of the Library
     * @param page      page number starting from 0
     * @param size      number of items per page
     * @return PageResult containing BookCopy entities in the library
     */
    default PageResult<BookCopy> findByLibraryId(Long libraryId, int page, int size) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Generic container for paginated results.
     *
     * @param <T> type of the content in the page
     */
    class PageResult<T> {
        private final List<T> content;
        private final int page;
        private final int size;
        private final long totalElements;

        public PageResult(List<T> content, int page, int size, long totalElements) {
            this.content = content;
            this.page = page;
            this.size = size;
            this.totalElements = totalElements;
        }

        public List<T> getContent() {
            return content;
        }

        public int getPage() {
            return page;
        }

        public int getSize() {
            return size;
        }

        public long getTotalElements() {
            return totalElements;
        }

        public int getTotalPages() {
            return (int) Math.ceil((double) totalElements / size);
        }
    }
}

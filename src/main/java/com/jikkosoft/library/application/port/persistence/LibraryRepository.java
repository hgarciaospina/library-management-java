package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.model.Library;
import com.jikkosoft.library.application.common.PagedResponse;

import java.util.Optional;

/**
 * Port for persisting and querying Library aggregates.
 *
 * Responsibilities:
 * - Persist Library entities.
 * - Retrieve libraries by ID or name.
 * - Support paginated retrieval of libraries.
 * - Soft delete libraries logically instead of physical removal.
 */
public interface LibraryRepository {

    /**
     * Retrieves a Library by its unique identifier.
     *
     * @param id unique identifier of the library
     * @return Optional containing the found library or empty if not found
     */
    Optional<Library> findById(Long id);

    /**
     * Retrieves a Library by its name (case-insensitive).
     *
     * @param name name of the library
     * @return Optional containing the found library or empty if not found
     */
    Optional<Library> findByNameIgnoreCase(String name);

    /**
     * Saves a Library entity.
     *
     * @param library entity to persist
     * @return persisted Library entity with ID and timestamps populated
     */
    Library save(Library library);

    /**
     * Retrieves all libraries in a paginated form.
     *
     * @param page zero-based page index
     * @param size number of items per page
     * @return paginated response of libraries
     */
    PagedResponse<Library> findAll(int page, int size);

    /**
     * Logically deletes a Library by its ID.
     * The record remains in the database, but marked as deleted.
     *
     * @param id unique identifier of the library to delete
     */
    void logicalDeleteById(Long id);
}

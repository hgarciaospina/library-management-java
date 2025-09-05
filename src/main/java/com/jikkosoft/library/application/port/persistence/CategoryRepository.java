package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.model.Category;
import com.jikkosoft.library.application.common.PagedResponse;

import java.util.Optional;

/**
 * Port for persisting and querying Category aggregates.
 *
 * Responsibilities:
 * - Persist Category entities.
 * - Retrieve categories by ID or name.
 * - Support paginated retrieval of categories.
 */
public interface CategoryRepository {

    /**
     * Retrieves a Category by its unique identifier.
     *
     * @param id unique identifier of the category
     * @return Optional containing the found category or empty if not found
     */
    Optional<Category> findById(Long id);

    /**
     * Retrieves a Category by its name (case-insensitive).
     *
     * @param name name of the category
     * @return Optional containing the found category or empty if not found
     */
    Optional<Category> findByNameIgnoreCase(String name);

    /**
     * Saves a Category entity.
     *
     * @param category entity to persist
     * @return persisted Category entity with ID and timestamps populated
     */
    Category save(Category category);

    /**
     * Retrieves all categories in a paginated form.
     *
     * @param page zero-based page index
     * @param size number of items per page
     * @return paginated response of categories
     */
    PagedResponse<Category> findAll(int page, int size);
}

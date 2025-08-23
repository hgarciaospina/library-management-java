package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.model.Category;

import java.util.Optional;

/**
 * Port for Category persistence.
 */
public interface CategoryRepository {
    Optional<Category> findById(Long id);
    Optional<Category> findByNameIgnoreCase(String name);
    Category save(Category category);
}

package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.domain.model.Library;

import java.util.Optional;

/**
 * Port for Library persistence.
 */
public interface LibraryRepository {
    Optional<Library> findById(Long id);
    Library save(Library library);
}

package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.application.common.PagedResponse;
import com.jikkosoft.library.domain.model.User;

import java.util.Optional;

/**
 * Port for persisting and querying User aggregates.
 *
 * Responsibilities:
 * - Provides CRUD operations (create, read, update, soft delete).
 * - Supports paginated queries.
 */
public interface UserRepository {

    /**
     * Retrieves a User by its unique identifier.
     *
     * @param id unique identifier of the user
     * @return Optional containing the found User, or empty if not found
     */
    Optional<User> findById(Long id);

    /**
     * Retrieves a User by their email address.
     *
     * @param email email of the user
     * @return Optional containing the found User, or empty if not found
     */
    Optional<User> findByEmail(String email);

    /**
     * Saves a User entity.
     * - If the entity has no ID, it is created.
     * - If the entity has an existing ID, it is updated.
     *
     * @param user User entity to persist
     * @return persisted User entity with ID and timestamps populated
     */
    User save(User user);

    /**
     * Soft deletes a User by its ID.
     * The record is marked as deleted but not removed from the database.
     *
     * @param id unique identifier of the User
     */
    void logicalDeleteById(Long id);

    /**
     * Retrieves a paginated list of all users.
     *
     * @param page page number starting from 0
     * @param size number of items per page
     * @return paginated response with users
     */
    PagedResponse<User> findAllPaged(int page, int size);

    /**
     * Retrieves a paginated list of users filtered by email.
     *
     * @param email partial or full email to filter
     * @param page  page number starting from 0
     * @param size  number of items per page
     * @return paginated response with users matching the email filter
     */
    PagedResponse<User> findByEmailPaged(String email, int page, int size);
}

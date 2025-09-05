package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.application.common.PagedResponse;
import com.jikkosoft.library.domain.enums.RoleType;
import com.jikkosoft.library.domain.model.Role;

import java.util.Optional;

/**
 * Port for persisting and querying Role aggregates.
 *
 * Responsibilities:
 * - Provides CRUD operations for Role entities.
 * - Supports soft delete (logical deletion).
 * - Provides paginated queries.
 * - Supports filtering by role type.
 */
public interface RoleRepository {

    /**
     * Retrieves a Role by its unique identifier.
     *
     * @param id unique identifier of the Role
     * @return Optional containing the found Role, or empty if not found
     */
    Optional<Role> findById(Long id);

    /**
     * Retrieves a Role by its type.
     *
     * @param roleType type of the Role (NORMAL_USER, ADMIN, SUPER_USER)
     * @return Optional containing the found Role, or empty if not found
     */
    Optional<Role> findByRoleType(RoleType roleType);

    /**
     * Saves a Role entity.
     * - If the entity has no ID, it is created.
     * - If the entity has an existing ID, it is updated.
     *
     * @param role Role entity to persist
     * @return persisted Role entity with ID and timestamps populated
     */
    Role save(Role role);

    /**
     * Soft deletes a Role by its ID.
     * The record is marked as deleted but not physically removed.
     *
     * @param id unique identifier of the Role
     */
    void logicalDeleteById(Long id);

    /**
     * Retrieves all Roles with pagination.
     *
     * @param page page number starting from 0
     * @param size number of items per page
     * @return paginated response with all roles
     */
    PagedResponse<Role> findAllPaged(int page, int size);

    /**
     * Retrieves Roles filtered by RoleType with pagination.
     *
     * @param roleType Role type to filter (nullable for all roles)
     * @param page     page number starting from 0
     * @param size     number of items per page
     * @return paginated response with roles matching the filter
     */
    PagedResponse<Role> findByRoleTypePaged(RoleType roleType, int page, int size);
}

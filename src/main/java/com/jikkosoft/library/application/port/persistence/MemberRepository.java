package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.application.common.PagedResponse;
import com.jikkosoft.library.domain.model.Member;

import java.util.Optional;

/**
 * Port for persisting and querying Member aggregates.
 *
 * Responsibilities:
 * - Provides CRUD operations (create, read, update, soft delete).
 * - Supports paginated queries.
 * - Supports lookup by email within a library.
 */
public interface MemberRepository {

    /**
     * Retrieves a Member by its unique identifier.
     *
     * @param id unique identifier of the member
     * @return Optional containing the found Member, or empty if not found
     */
    Optional<Member> findById(Long id);

    /**
     * Retrieves a Member by email within a specific library.
     *
     * @param email     email address of the member
     * @param libraryId ID of the library
     * @return Optional containing the found Member, or empty if not found
     */
    Optional<Member> findByEmailInLibrary(String email, Long libraryId);

    /**
     * Saves a Member entity.
     * - If the entity has no ID, it is created.
     * - If the entity has an existing ID, it is updated.
     *
     * @param member Member entity to persist
     * @return persisted Member entity with ID and timestamps populated
     */
    Member save(Member member);

    /**
     * Soft deletes a Member by its ID.
     * The record is marked as deleted but not removed from the database.
     *
     * @param id unique identifier of the Member
     */
    void logicalDeleteById(Long id);

    /**
     * Retrieves a paginated list of members.
     *
     * @param page page number starting from 0
     * @param size number of items per page
     * @return paginated response with members
     */
    PagedResponse<Member> findAllPaged(int page, int size);

    /**
     * Retrieves a paginated list of members filtered by name.
     *
     * @param name partial or full name to search
     * @param page page number starting from 0
     * @param size number of items per page
     * @return paginated response with members matching the name filter
     */
    PagedResponse<Member> findByNamePaged(String name, int page, int size);
}

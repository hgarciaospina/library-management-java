package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.application.common.PagedResponse;
import com.jikkosoft.library.domain.enums.LoanStatus;
import com.jikkosoft.library.domain.model.Loan;

import java.util.List;
import java.util.Optional;

/**
 * Port for persisting and querying Loan aggregates.
 *
 * Responsibilities:
 * - Provides CRUD operations (create, read, update, soft delete).
 * - Supports pagination for list queries.
 * - Supports retrieval by member ID and loan status.
 */
public interface LoanRepository {

    /**
     * Retrieves a Loan by its unique identifier.
     *
     * @param id unique identifier of the Loan
     * @return Optional containing the found Loan, or empty if not found
     */
    Optional<Loan> findById(Long id);

    /**
     * Saves a Loan entity.
     * - If the entity has no ID, it is created.
     * - If the entity has an existing ID, it is updated.
     *
     * @param loan Loan entity to persist
     * @return persisted Loan entity with ID and timestamps populated
     */
    Loan save(Loan loan);

    /**
     * Retrieves all loans for a given member filtered by status.
     *
     * @param memberId ID of the member
     * @param status   status to filter by (optional, can be null)
     * @return list of loans matching criteria
     */
    List<Loan> findByMemberIdAndStatus(Long memberId, LoanStatus status);

    /**
     * Soft deletes a Loan by its ID.
     * The record is marked as deleted but not removed from the database.
     *
     * @param id unique identifier of the Loan
     */
    void logicalDeleteById(Long id);

    /**
     * Retrieves a paginated list of loans for a given member filtered by status.
     *
     * @param memberId ID of the member
     * @param status   optional status to filter by
     * @param page     page number starting from 0
     * @param size     number of items per page
     * @return paginated response with loans
     */
    PagedResponse<Loan> findByMemberIdAndStatusPaged(Long memberId, LoanStatus status, int page, int size);
}

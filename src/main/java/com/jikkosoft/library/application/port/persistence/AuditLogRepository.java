package com.jikkosoft.library.application.port.persistence;

import com.jikkosoft.library.shared.common.AuditLog;
import com.jikkosoft.library.domain.enums.AuditAction;
import com.jikkosoft.library.application.common.PagedResponse;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Port for audit logging persistence and retrieval.
 *
 * Responsibilities:
 * - Persist audit records.
 * - Provide full CRUD access for AuditLog entities.
 * - Support retrieval by filters, including action type, user ID, and paginated results.
 */
public interface AuditLogRepository {

    /**
     * Logs an audit record describing who did what and when.
     *
     * @param actorUserId user performing the action (nullable for system jobs)
     * @param action      short action key (e.g., "BOOK_CREATED", "RESERVATION_EXPIRED")
     * @param details     human-readable details
     * @param at          timestamp of the event
     */
    void logAudit(Long actorUserId, String action, String details, LocalDateTime at);

    /**
     * Saves a complete AuditLog entity.
     *
     * @param auditLog entity to persist
     * @return persisted entity with ID and timestamps populated
     */
    AuditLog save(AuditLog auditLog);

    /**
     * Retrieves an AuditLog by its ID.
     *
     * @param id unique identifier of the audit log
     * @return Optional containing the found entity or empty if not found
     */
    Optional<AuditLog> findById(Long id);

    /**
     * Retrieves all AuditLog entries in a paginated form.
     *
     * @param page zero-based page index
     * @param size number of items per page
     * @return paginated response of audit logs
     */
    PagedResponse<AuditLog> findAll(int page, int size);

    /**
     * Retrieves AuditLog entries filtered by action type and/or user ID in a paginated form.
     *
     * @param action        optional action type filter
     * @param performedById optional user ID filter
     * @param page          zero-based page index
     * @param size          number of items per page
     * @return paginated response of audit logs matching filters
     */
    PagedResponse<AuditLog> findByActionAndUser(AuditAction action, Long performedById, int page, int size);
}

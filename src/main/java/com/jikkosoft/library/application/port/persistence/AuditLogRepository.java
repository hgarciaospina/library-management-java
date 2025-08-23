package com.jikkosoft.library.application.port.persistence;

import java.time.LocalDateTime;

/**
 * Port for audit logging. Each implementation decides the storage.
 */
public interface AuditLogRepository {

    /**
     * Persists an audit record describing who did what and when.
     *
     * @param actorUserId   user performing the action (nullable for system jobs)
     * @param action        short action key (e.g., "BOOK_CREATED", "RESERVATION_EXPIRED")
     * @param details       human-readable details
     * @param at            timestamp of the event
     */
    void record(Long actorUserId, String action, String details, LocalDateTime at);
}

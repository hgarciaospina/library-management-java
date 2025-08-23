package com.jikkosoft.library.domain.enums;

/**
 * Enum representing the type of auditable actions in the system.
 * Used by {@code AuditLog} to classify the operation performed.
 *
 * Typical actions:
 * - CREATE / UPDATE / DELETE: CRUD operations on domain entities.
 * - SOFT_DELETE / RESTORE: logical delete and restoration.
 * - STATUS_CHANGE: changes on state machines (e.g., loan or reservation status).
 * - Domain-specific actions like LOAN_CREATED, RESERVATION_PLACED, etc.
 */
public enum AuditAction {
    CREATE,
    UPDATE,
    DELETE,
    SOFT_DELETE,
    RESTORE,
    STATUS_CHANGE,

    // Domain-oriented actions (optional extension points)
    LOAN_CREATED,
    LOAN_RETURNED,
    RESERVATION_PLACED,
    RESERVATION_CANCELLED,

    LOGIN,
    LOGOUT,
    OTHER
}

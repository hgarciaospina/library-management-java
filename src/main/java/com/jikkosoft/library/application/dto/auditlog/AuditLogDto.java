package com.jikkosoft.library.application.dto.auditlog;

import com.jikkosoft.library.domain.enums.AuditAction;
import com.jikkosoft.library.application.dto.user.UserDto;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Full Data Transfer Object for AuditLog.
 *
 * Responsibilities:
 * - Represents a complete audit log entry for API exposure.
 * - Includes actor, action, target entity, timestamps, status, and optional snapshots.
 * - Immutable and safe for read operations.
 */
public record AuditLogDto(

        /** Unique identifier of the audit log. */
        Long id,

        /** User who performed the action. */
        UserDto performedBy,

        /** Type of action performed (CREATE, UPDATE, DELETE, etc.). */
        AuditAction action,

        /** Logical name of the affected entity (e.g., Book, Member). */
        String entityType,

        /** Identifier of the affected entity. */
        String entityId,

        /** Timestamp when the action occurred. */
        LocalDateTime timestamp,

        /** Whether the action completed successfully. */
        boolean success,

        /** Optional human-readable message/context. */
        String message,

        /** Optional correlation/request ID for tracing. */
        String correlationId,

        /** Snapshot before the action (optional, JSON/plain text). */
        String before,

        /** Snapshot after the action (optional, JSON/plain text). */
        String after,

        /** Additional structured metadata. */
        Map<String, String> metadata
) {}

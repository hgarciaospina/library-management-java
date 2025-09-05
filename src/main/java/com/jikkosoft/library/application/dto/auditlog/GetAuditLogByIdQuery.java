package com.jikkosoft.library.application.dto.auditlog;

import jakarta.validation.constraints.NotNull;

/**
 * Query to retrieve a single AuditLog entry by its ID.
 *
 * Responsibilities:
 * - Encapsulates the identifier of the audit log entry.
 * - Immutable structure using Java record.
 */
public record GetAuditLogByIdQuery(

        /** Identifier of the audit log entry (required). */
        @NotNull(message = "AuditLog ID is required")
        Long id

) {}

package com.jikkosoft.library.application.dto.auditlog;

import com.jikkosoft.library.domain.enums.AuditAction;
import com.jikkosoft.library.domain.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import java.util.Map;

/**
 * Command to update an existing AuditLog entry.
 *
 * Responsibilities:
 * - Provides fields that can be updated for an audit log entry.
 * - Maintains consistency with other commands using Lombok @Data and @Builder.
 * - Enforces validation at the application boundary.
 */
@Data
@Builder
public class UpdateAuditLogCommand {

    /** Identifier of the audit log entry to update (required). */
    @NotNull(message = "AuditLog ID is required")
    private Long id;

    /** User who performed the action (required). */
    @NotNull(message = "PerformedBy user is required")
    private User performedBy;

    /** Type of action performed (required). */
    @NotNull(message = "AuditAction is required")
    private AuditAction action;

    /** Logical name of the affected entity (required). */
    @NotBlank(message = "Entity type is required")
    @Size(max = 100, message = "Entity type cannot exceed 100 characters")
    private String entityType;

    /** Identifier of the affected entity (required). */
    @NotBlank(message = "Entity ID is required")
    @Size(max = 50, message = "Entity ID cannot exceed 50 characters")
    private String entityId;

    /** Whether the action was successful (optional). */
    private boolean success;

    /** Human-readable message for the audit (optional). */
    @Size(max = 500, message = "Message cannot exceed 500 characters")
    private String message;

    /** Correlation ID for tracing (optional). */
    @Size(max = 100, message = "Correlation ID cannot exceed 100 characters")
    private String correlationId;

    /** Snapshot of the entity before the action (optional). */
    private String before;

    /** Snapshot of the entity after the action (optional). */
    private String after;

    /** Additional metadata (optional). */
    private Map<String, String> metadata;
}

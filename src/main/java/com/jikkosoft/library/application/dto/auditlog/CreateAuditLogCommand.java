package com.jikkosoft.library.application.dto.auditlog;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.jikkosoft.library.domain.enums.AuditAction;
import com.jikkosoft.library.application.dto.user.UserDto;

import java.util.Map;

/**
 * Command to create a new AuditLog entry.
 *
 * Responsibilities:
 * - Encapsulates all required fields for creating an audit record.
 * - Validates mandatory fields at the boundary.
 */
@Data
@Builder
public class CreateAuditLogCommand {

    /** User performing the action (required). */
    @NotNull(message = "PerformedBy is required")
    private UserDto performedBy;

    /** Action type (required). */
    @NotNull(message = "Action type is required")
    private AuditAction action;

    /** Affected entity type (required). */
    @NotNull(message = "Entity type is required")
    @Size(min = 1, max = 100, message = "Entity type cannot be blank or exceed 100 characters")
    private String entityType;

    /** Identifier of the affected entity (required). */
    @NotNull(message = "Entity ID is required")
    private String entityId;

    /** Optional success flag (default true). */
    private boolean success = true;

    /** Optional human-readable message. */
    private String message;

    /** Optional correlation/request ID. */
    private String correlationId;

    /** Optional snapshot before the action. */
    private String before;

    /** Optional snapshot after the action. */
    private String after;

    /** Optional structured metadata. */
    private Map<String, String> metadata;
}

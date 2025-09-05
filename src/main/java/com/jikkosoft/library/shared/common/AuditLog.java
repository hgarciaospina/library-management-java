package com.jikkosoft.library.shared.common;

import com.jikkosoft.library.domain.enums.AuditAction;
import com.jikkosoft.library.domain.model.User;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Domain model representing an audit log entry.
 * Captures who did what, to which entity, when, and with what outcome.
 *
 * Core responsibilities:
 * - Record actor (who performed the action).
 * - Record action type (what was performed).
 * - Record target (which entity type and entity id were affected).
 * - Record timestamp (when it happened).
 * - Capture success/failure and a human-readable message.
 * - Optionally store 'before' and 'after' snapshots (JSON or plain text).
 * - Optionally store correlationId/requestId for tracing across layers.
 * - Optionally store metadata as key/value pairs (immutable view).
 *
 * Notes:
 * - This class is immutable except for Builder usage.
 * - Snapshots ('before'/'after') are stored as strings for flexibility (e.g., JSON).
 */
public class AuditLog {

    /** Optional domain identifier (nullable for transient instances). */
    private final Long id;

    /** User who performed the action. */
    private final User performedBy;

    /** Type of action performed. */
    private final AuditAction action;

    /** Logical name of the affected entity (e.g., "Book", "Member", "Reservation"). */
    private final String entityType;

    /** Identifier of the affected entity (as String to support numeric IDs or UUIDs). */
    private final String entityId;

    /** Audit timestamp (captured at creation). */
    private final LocalDateTime timestamp;

    /** Whether the action completed successfully. */
    private final boolean success;

    /** Human-readable message/context for the event (optional). */
    private final String message;

    /** Correlation identifier for cross-cutting tracing (optional, e.g., requestId). */
    private final String correlationId;

    /** Snapshot before the action (optional: JSON or plain text). */
    private final String before;

    /** Snapshot after the action (optional: JSON or plain text). */
    private final String after;

    /** Additional structured data as key/value pairs (immutable view). */
    private final Map<String, String> metadata;

    /**
     * Private constructor for Builder usage.
     *
     * @param builder Builder instance
     */
    private AuditLog(Builder builder) {
        if (builder.performedBy == null) throw new IllegalArgumentException("performedBy must not be null.");
        if (builder.action == null) throw new IllegalArgumentException("action must not be null.");
        if (builder.entityType == null || builder.entityType.isBlank()) throw new IllegalArgumentException("entityType must not be null or blank.");
        if (builder.entityId == null || builder.entityId.isBlank()) throw new IllegalArgumentException("entityId must not be null or blank.");

        this.id = builder.id;
        this.performedBy = builder.performedBy;
        this.action = builder.action;
        this.entityType = builder.entityType.trim();
        this.entityId = builder.entityId.trim();
        this.timestamp = builder.timestamp != null ? builder.timestamp : LocalDateTime.now();
        this.success = builder.success;
        this.message = builder.message;
        this.correlationId = builder.correlationId;
        this.before = builder.before;
        this.after = builder.after;
        this.metadata = builder.metadata != null ? Collections.unmodifiableMap(new HashMap<>(builder.metadata)) : Collections.emptyMap();
    }

    /* ======================= Builder ======================= */
    public static class Builder {
        private Long id;
        private User performedBy;
        private AuditAction action;
        private String entityType;
        private String entityId;
        private LocalDateTime timestamp;
        private boolean success = true;
        private String message;
        private String correlationId;
        private String before;
        private String after;
        private Map<String, String> metadata;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder performedBy(User performedBy) { this.performedBy = performedBy; return this; }
        public Builder action(AuditAction action) { this.action = action; return this; }
        public Builder entityType(String entityType) { this.entityType = entityType; return this; }
        public Builder entityId(String entityId) { this.entityId = entityId; return this; }
        public Builder timestamp(LocalDateTime timestamp) { this.timestamp = timestamp; return this; }
        public Builder success(boolean success) { this.success = success; return this; }
        public Builder message(String message) { this.message = message; return this; }
        public Builder correlationId(String correlationId) { this.correlationId = correlationId; return this; }
        public Builder before(String before) { this.before = before; return this; }
        public Builder after(String after) { this.after = after; return this; }
        public Builder metadata(Map<String, String> metadata) { this.metadata = metadata; return this; }

        public AuditLog build() { return new AuditLog(this); }
    }

    /* ======================= Getters ======================= */
    public Long getId() { return id; }
    public User getPerformedBy() { return performedBy; }
    public AuditAction getAction() { return action; }
    public String getEntityType() { return entityType; }
    public String getEntityId() { return entityId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public String getCorrelationId() { return correlationId; }
    public String getBefore() { return before; }
    public String getAfter() { return after; }
    public Map<String, String> getMetadata() { return metadata; }

    /* ======================= Equality & Debug ======================= */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditLog)) return false;
        AuditLog that = (AuditLog) o;
        return Objects.equals(timestamp, that.timestamp) &&
                action == that.action &&
                Objects.equals(entityType, that.entityType) &&
                Objects.equals(entityId, that.entityId) &&
                Objects.equals(performedBy, that.performedBy);
    }

    @Override
    public int hashCode() { return Objects.hash(timestamp, action, entityType, entityId, performedBy); }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", performedBy=" + (performedBy != null ? performedBy.getId() : null) +
                ", action=" + action +
                ", entityType='" + entityType + '\'' +
                ", entityId='" + entityId + '\'' +
                ", timestamp=" + timestamp +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }
}

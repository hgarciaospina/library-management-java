package com.jikkosoft.library.domain.model;

import java.time.LocalDateTime;

/**
 * Represents an audit log entry.
 * Records all actions performed by users for traceability.
 */
public class AuditLog {

    private final Long id;
    private final User performedBy;
    private final String action;
    private final LocalDateTime timestamp;

    public AuditLog(Long id, User performedBy, String action) {
        this.id = id;
        this.performedBy = performedBy;
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public User getPerformedBy() { return performedBy; }
    public String getAction() { return action; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

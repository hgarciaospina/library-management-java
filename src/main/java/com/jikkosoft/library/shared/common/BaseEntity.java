package com.jikkosoft.library.shared.common;

import java.time.LocalDateTime;

/**
 * Abstract base entity for all domain models.
 * Provides consistency and common audit fields across all entities:
 * - Creation timestamp (createdAt)
 * - Last update timestamp (updatedAt)
 * - Logical deletion timestamp (deletedAt)
 *
 * Core responsibilities:
 * - Track creation and last update times automatically.
 * - Support soft deletion with markDeleted and restore methods.
 * - Ensure invariants for audit fields.
 *
 * Notes:
 * - This is a pure domain class, no persistence annotations included.
 * - All domain entities should extend this class.
 */
public abstract class BaseEntity {

    /** Timestamp when the entity was created. Immutable after initialization. */
    protected final LocalDateTime createdAt;

    /** Timestamp when the entity was last updated. */
    protected LocalDateTime updatedAt;

    /** Timestamp when the entity was logically deleted. Null if not deleted. */
    protected LocalDateTime deletedAt;

    /**
     * Default constructor initializes creation and update timestamps.
     * deletedAt is initialized to null (not deleted).
     */
    protected BaseEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.deletedAt = null;
    }

    /**
     * Protected constructor to allow explicit timestamps (e.g., when loading from DB).
     *
     * @param createdAt Creation timestamp.
     * @param updatedAt Last update timestamp.
     * @param deletedAt Deletion timestamp (nullable).
     */
    protected BaseEntity(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.createdAt = (createdAt != null) ? createdAt : LocalDateTime.now();
        this.updatedAt = (updatedAt != null) ? updatedAt : LocalDateTime.now();
        this.deletedAt = deletedAt;
    }

    /**
     * Marks the entity as updated by refreshing the updatedAt timestamp.
     */
    public void markUpdated() {
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Marks the entity as logically deleted by setting deletedAt timestamp.
     */
    public void markDeleted() {
        this.deletedAt = LocalDateTime.now();
    }

    /**
     * Restores the entity from logical deletion.
     */
    public void restore() {
        this.deletedAt = null;
    }

    /** @return Creation timestamp of the entity. */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /** @return Last update timestamp of the entity. */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /** @return Deletion timestamp, null if entity is not deleted. */
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    /** @return true if entity is logically deleted, false otherwise. */
    public boolean isDeleted() {
        return deletedAt != null;
    }
}

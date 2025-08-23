package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.RoleType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Domain model representing a system User.
 *
 * Responsibilities:
 * - Holds account credentials and activation status.
 * - Tracks assigned Roles (business roles/permissions).
 * - Supports activation/deactivation and password updates.
 *
 * Invariants:
 * - email and password cannot be null or blank.
 * - Roles cannot contain null elements.
 *
 * Notes:
 * - Builder pattern ensures safe and validated construction.
 * - Inherits from BaseEntity for audit tracking and soft deletion.
 */
public class User extends BaseEntity {

    private final Long id;
    private final String email;
    private String password;
    private final Set<Role> roles = new HashSet<>();
    private boolean active;

    // ======================= Private constructor =======================
    private User(Builder builder) {
        super();
        if (builder.email == null || builder.email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (builder.password == null || builder.password.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }

        this.id = builder.id;
        this.email = builder.email.trim().toLowerCase();
        this.password = builder.password;
        this.active = builder.active != null ? builder.active : true;

        if (builder.roles != null) {
            builder.roles.forEach(r -> {
                if (r != null) this.roles.add(r);
            });
        }
    }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private String email;
        private String password;
        private Set<Role> roles;
        private Boolean active;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder password(String password) { this.password = password; return this; }
        public Builder roles(Set<Role> roles) { this.roles = roles; return this; }
        public Builder active(Boolean active) { this.active = active; return this; }

        public User build() { return new User(this); }
    }

    // ======================= Getters / Mutators =======================
    public Long getId() { return id; }
    public String getEmail() { return email; }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        this.password = password;
        markUpdated();
    }

    public Set<Role> getRoles() { return Collections.unmodifiableSet(roles); }
    public void addRole(Role role) {
        if (role != null) {
            roles.add(role);
            markUpdated();
        }
    }

    public boolean hasRole(RoleType roleType) {
        return roles.stream().anyMatch(r -> r.getRoleType() == roleType);
    }

    public boolean isActive() { return active; }
    public void deactivate() { this.active = false; markUpdated(); }
    public void activate() { this.active = true; markUpdated(); }

    // ======================= Equals & HashCode =======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", active=" + active +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }
}

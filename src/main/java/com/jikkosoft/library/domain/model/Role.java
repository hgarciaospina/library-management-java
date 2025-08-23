package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.RoleType;
import java.util.Objects;

/**
 * Domain model representing a user role in the system.
 * Roles are assigned to Users to define permissions.
 */
public class Role extends BaseEntity {

    private final Long id;
    private final RoleType roleType;

    public Role(Long id, RoleType roleType) {
        super();
        if (roleType == null) {
            throw new IllegalArgumentException("RoleType cannot be null");
        }
        this.id = id;
        this.roleType = roleType;
    }

    public Long getId() { return id; }
    public RoleType getRoleType() { return roleType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleType=" + roleType +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }
}

package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.RoleType;

/**
 * Represents a user role within the system.
 * Each user can have one or multiple roles assigned.
 */
public class Role {

    private final Long id;
    private final RoleType roleType;

    public Role(Long id, RoleType roleType) {
        this.id = id;
        this.roleType = roleType;
    }

    public Long getId() { return id; }

    public RoleType getRoleType() { return roleType; }
}

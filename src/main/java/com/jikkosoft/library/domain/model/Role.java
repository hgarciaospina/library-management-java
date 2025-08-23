package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.RoleType;

/**
 * Represents user roles within the system.
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

    /** Returns the type of this role (NORMAL_USER, ADMIN, SUPER_USER). */
    public RoleType getRoleType() { return roleType; }
}

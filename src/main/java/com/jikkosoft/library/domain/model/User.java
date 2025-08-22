package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.vo.Email;
import com.jikkosoft.library.domain.enums.RoleType;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a system user.
 * Users can have multiple roles and be associated with multiple libraries.
 */
public class User {

    private final Long id;
    private final Email email;
    private String password;
    private final Set<Role> roles = new HashSet<>();
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(Long id, Email email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.active = true;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Email getEmail() { return email; }
    public String getPassword() { return password; }
    public Set<Role> getRoles() { return roles; }
    public boolean isActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setPassword(String password) { this.password = password; }

    public void addRole(Role role) { roles.add(role); }

    /**
     * Checks if the user has a specific role.
     * @param roleType RoleType to check
     * @return true if the user has the role
     */
    public boolean hasRole(RoleType roleType) {
        return roles.stream().anyMatch(role -> role.getRoleType() == roleType);
    }

    public void deactivate() {
        this.active = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void activate() {
        this.active = true;
        this.updatedAt = LocalDateTime.now();
    }
}

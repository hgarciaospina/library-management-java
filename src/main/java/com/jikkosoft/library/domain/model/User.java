package com.jikkosoft.library.domain.model;

import com.jikkosoft.library.domain.enums.RoleType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a system user holding roles and account state.
 * Domain simplified for the purpose of the example.
 */
public class User {

    private final Long id;
    private final String email;
    private String password;
    private final Set<Role> roles = new HashSet<>();
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(Long id, String email, String password) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("email required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("password required");
        this.id = id;
        this.email = email.trim().toLowerCase();
        this.password = password;
        this.active = true;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setPassword(String password) {
        if (password == null || password.isBlank()) throw new IllegalArgumentException("password required");
        this.password = password; this.updatedAt = LocalDateTime.now();
    }
    public Set<Role> getRoles() { return roles; }
    public boolean isActive() { return active; }

    public void addRole(Role role) { if (role != null) roles.add(role); }
    public boolean hasRole(RoleType roleType) {
        return roles.stream().anyMatch(r -> r.getRoleType() == roleType);
    }
    public void deactivate() { this.active = false; this.updatedAt = LocalDateTime.now(); }
    public void activate() { this.active = true; this.updatedAt = LocalDateTime.now(); }
}

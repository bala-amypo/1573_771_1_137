package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "role_permissions")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Role role;

    @ManyToOne(optional = false)
    private Permission permission;

    private Instant grantedAt;

    public RolePermission() {}

    public RolePermission(Role role, Permission permission) {
        this.role = role;
        this.permission = permission;
    }

    @PrePersist
    void onGrant() {
        this.grantedAt = Instant.now();
    }

    // getters
    public Long getId() { return id; }
    public Role getRole() { return role; }
    public Permission getPermission() { return permission; }
}

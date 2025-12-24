package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permissionKey;
    private String description;
    private boolean active = true;

    // ===== REQUIRED BY TESTS =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isActive() { return active; }
    public boolean getActive() { return active; }   // 👈 REQUIRED
    public void setActive(boolean active) { this.active = active; }

    // ===== SERVICE EXPECTED =====
    public String getPermissionKey() { return permissionKey; }
    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }
}

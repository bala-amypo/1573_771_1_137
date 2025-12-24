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
    private Boolean active = true;

    public Long getId() {
        return id;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    // 🔴 REQUIRED
    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    // 🔴 REQUIRED
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public boolean isActive() {
        return Boolean.TRUE.equals(active);
    }

    // 🔴 REQUIRED
    public void setActive(boolean active) {
        this.active = active;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permissionKey;
    private String description;
    private boolean active = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // ===================== GETTERS =====================

    public Long getId() {
        return id;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public String getDescription() {
        return description;
    }

    public boolean getActive() {
        return active;
    }

    public boolean isActive() {
        return active;
    }

    // ===================== SETTERS =====================

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // ===================== JPA LIFECYCLE =====================

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

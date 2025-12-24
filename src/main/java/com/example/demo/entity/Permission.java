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

    private Boolean active = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /* ================= REQUIRED BY TESTS ================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {            // TESTS CALL setId()
        this.id = id;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) { // TESTS CALL setPermissionKey()
        this.permissionKey = permissionKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { // TESTS CALL setDescription()
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public boolean isActive() {             // TESTS CALL isActive()
        return Boolean.TRUE.equals(active);
    }

    public void setActive(boolean active) { // TESTS CALL setActive()
        this.active = active;
    }

    /* ================= LIFECYCLE (MANDATORY) ================= */

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

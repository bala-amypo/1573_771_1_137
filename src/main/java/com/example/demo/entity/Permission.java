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

    /* ================= REQUIRED BY TESTS ================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {               // ✅ REQUIRED
        this.id = id;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) { // ✅ REQUIRED
        this.permissionKey = permissionKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {     // ✅ REQUIRED
        this.description = description;
    }

    public boolean getActive() {
        return active;
    }

    public boolean isActive() {                // ✅ REQUIRED
        return active;
    }

    public void setActive(boolean active) {    // ✅ REQUIRED
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /* ================= JPA LIFECYCLE ================= */

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

} // ✅ <<< THIS CLOSING BRACE WAS MISSING

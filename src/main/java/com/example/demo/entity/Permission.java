package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "permissions",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "permissionKey")
    }
)
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permissionKey;

    private String description;

    private Boolean active = true;

    public Permission() {
    }

    public Permission(String permissionKey, String description, Boolean active) {
        this.permissionKey = permissionKey;
        this.description = description;
        this.active = active != null ? active : true;
    }

    /* ===== GETTERS ===== */

    public Long getId() {
        return id;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return active;
    }

    /* ===== SETTERS ===== */

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

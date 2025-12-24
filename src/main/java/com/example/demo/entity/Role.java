package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;
    private String description;
    private Boolean active = true;

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    // 🔴 REQUIRED
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

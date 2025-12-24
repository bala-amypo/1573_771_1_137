package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // services expect getRoleName()
    @Column(unique = true, nullable = false)
    private String roleName;

    private String description;

    private boolean active = true;

    @ManyToMany
    private Set<Permission> permissions;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // ===== REQUIRED =====
    public String getRoleName() {
        return roleName;
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

    public void setActive(boolean active) {
        this.active = active;
    }

    // ===== setters =====
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    // services expect getFullName()
    private String fullName;

    private boolean active = true;

    @ManyToMany
    private Set<Role> roles;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // ===== REQUIRED =====
    public String getFullName() {
        return fullName;
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
    public void setFullName(String fullName) {
        this.fullName = fullName;
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

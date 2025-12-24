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

    private String fullName;

    private boolean active = true;

    @ManyToMany
    private Set<Role> roles;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // ===== REQUIRED GETTERS =====
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean getActive() {
        return active;
    }

    public boolean isActive() {
        return active;
    }

    // ===== REQUIRED SETTERS =====
    public void setActive(boolean active) {
        this.active = active;
    }

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

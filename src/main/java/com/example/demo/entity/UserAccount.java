package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String fullName;
    private String password;
    private Boolean active = true;

    private Instant createdAt;
    private Instant updatedAt;

    public UserAccount() {}

    public UserAccount(String email, String fullName, Boolean active) {
        this.email = email;
        this.fullName = fullName;
        this.active = active != null ? active : true;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        if (active == null) active = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }

    /* ===== GETTERS ===== */
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getFullName() { return fullName; }
    public String getPassword() { return password; }

    // required by tests
    public Boolean isActive() { return active; }

    // required by services
    public Boolean getActive() { return active; }

    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    /* ===== SETTERS ===== */
    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPassword(String password) { this.password = password; }
    public void setActive(Boolean active) { this.active = active; }
}

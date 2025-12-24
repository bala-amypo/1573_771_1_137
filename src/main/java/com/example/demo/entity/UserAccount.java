package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String fullName;

    private boolean active = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /* ================= REQUIRED BY TESTS ================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {          // ✅ REQUIRED
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {  // ✅ REQUIRED
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { // ✅ REQUIRED
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) { // ✅ REQUIRED
        this.fullName = fullName;
    }

    public boolean getActive() {
        return active;
    }

    public boolean isActive() {            // ✅ REQUIRED (TESTS CALL isActive)
        return active;
    }

    public void setActive(boolean active) { // ✅ REQUIRED
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {  // ✅ REQUIRED
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {  // ✅ REQUIRED
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
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private String fullName;

    private Boolean active = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /* =========================
       REQUIRED GETTERS/SETTERS
       ========================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 🔴 REQUIRED BY TESTS
    public String getPassword() {
        return password;
    }

    // 🔴 REQUIRED BY TESTS
    public void setPassword(String password) {
        this.password = password;
    }

    // 🔴 REQUIRED BY ERROR
    public String getFullName() {
        return fullName;
    }

    // 🔴 REQUIRED
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // 🔴 REQUIRED BY ERROR
    public Boolean getActive() {
        return active;
    }

    // 🔴 REQUIRED
    public void setActive(Boolean active) {
        this.active = active;
    }

    // 🔴 REQUIRED BY TESTS
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // 🔴 REQUIRED
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // 🔴 REQUIRED BY TESTS
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // 🔴 REQUIRED
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

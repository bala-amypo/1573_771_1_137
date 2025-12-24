package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String email;
    private String fullName;

    private boolean active = true;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // ===== REQUIRED BY TESTS =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isActive() { return active; }
    public boolean getActive() { return active; }   // 👈 REQUIRED
    public void setActive(boolean active) { this.active = active; }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }

    // ===== SERVICE EXPECTED =====
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}

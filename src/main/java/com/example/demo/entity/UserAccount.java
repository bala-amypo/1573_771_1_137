package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_accounts", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private Boolean active = true;

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    public Long getId() {
    return id;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getFullName() {
    return fullName;
}

public void setFullName(String fullName) {
    this.fullName = fullName;
}

public Boolean getActive() {
    return active;
}

public void setActive(Boolean active) {
    this.active = active;
}

public Instant getCreatedAt() {
    return createdAt;
}

public Instant getUpdatedAt() {
    return updatedAt;
}

}

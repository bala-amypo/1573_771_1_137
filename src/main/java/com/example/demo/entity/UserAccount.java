package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "user_accounts", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserAccount {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false, unique = true)
private String email;


@Column(nullable = false)
private String fullName;


@Column
private String password;


@Column(nullable = false)
private Boolean active = true;


@Column(nullable = false, updatable = false)
private Instant createdAt;


@Column(nullable = false)
private Instant updatedAt;


public UserAccount() {
}


public UserAccount(String email, String fullName, Boolean active) {
this.email = email;
this.fullName = fullName;
this.active = active != null ? active : true;
}


@PrePersist
void onCreate() {
Instant now = Instant.now();
this.createdAt = now;
this.updatedAt = now;
}


@PreUpdate
void onUpdate() {
this.updatedAt = Instant.now();
}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
public String getFullName() { return fullName; }
public void setFullName(String fullName) { this.fullName = fullName; }
public String getPassword() { return password; }
}
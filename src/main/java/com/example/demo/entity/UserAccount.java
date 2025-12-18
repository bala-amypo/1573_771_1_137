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


@Column
private String password;


@Column(nullable = false)
private Boolean active = true;


@Column(updatable = false)
private Instant createdAt;


private Instant updatedAt;


public UserAccount() {}


public UserAccount(String email, String fullName, Boolean active) {
this.email = email;
this.fullName = fullName;
this.active = active != null ? active : true;
}


@PrePersist
public void onCreate() {
this.createdAt = Instant.now();
this.updatedAt = Instant.now();
if (this.active == null) {
this.active = true;
}
}


@PreUpdate
public void onUpdate() {
this.updatedAt = Instant.now();
}


// Getters and Setters
}
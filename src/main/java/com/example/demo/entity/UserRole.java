package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "user_roles",
uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"}))
public class UserRole {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne(optional = false)
@JoinColumn(name = "user_id")
private UserAccount user;


@ManyToOne(optional = false)
@JoinColumn(name = "role_id")
private Role role;


@Column(updatable = false)
private Instant assignedAt;


public UserRole() {}


public UserRole(UserAccount user, Role role) {
this.user = user;
this.role = role;
}


@PrePersist
public void onAssign() {
this.assignedAt = Instant.now();
}


// Getters and S
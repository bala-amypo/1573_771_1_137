package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "role_permissions",
uniqueConstraints = @UniqueConstraint(columnNames = {"role_id", "permission_id"}))
public class RolePermission {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne(optional = false)
@JoinColumn(name = "role_id")
private Role role;


@ManyToOne(optional = false)
@JoinColumn(name = "permission_id")
private Permission permission;


@Column(updatable = false)
private Instant grantedAt;


public RolePermission() {}


public RolePermission(Role role, Permission permission) {
this.role = role;
this.permission = permission;
}


@PrePersist
public void onGrant() {
this.grantedAt = Instant.now();
}


// Getters and Setters
}
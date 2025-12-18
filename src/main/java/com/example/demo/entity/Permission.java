package com.example.demo.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "permissions", uniqueConstraints = {
@UniqueConstraint(columnNames = "permissionKey")
})
public class Permission {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false, unique = true)
private String permissionKey;


private String description;


@Column(nullable = false)
private Boolean active = true;


public Permission() {}


public Permission(String permissionKey, String description, Boolean active) {
this.permissionKey = permissionKey;
this.description = description;
this.active = active != null ? active : true;
}


// Getters and Sette
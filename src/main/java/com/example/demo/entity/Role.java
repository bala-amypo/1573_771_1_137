package com.example.demo.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "roles", uniqueConstraints = {
@UniqueConstraint(columnNames = "roleName")
})
public class Role {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false, unique = true)
private String roleName;


private String description;


@Column(nullable = false)
private Boolean active = true;


public Role() {}


public Role(String roleName, String description, Boolean active) {
this.roleName = roleName;
this.description = description;
this.active = active != null ? active : true;
}


// Getters and Setters
}
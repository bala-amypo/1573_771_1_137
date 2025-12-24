package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;
    private String description;
    private Boolean active = true;

    public Role() {}

    public Role(String roleName, String description, Boolean active) {
        this.roleName = roleName;
        this.description = description;
        this.active = active != null ? active : true;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoleName() { return roleName; }
    public String getDescription() { return description; }

    public Boolean isActive() { return active; }

    public void setRoleName(String roleName) { this.roleName = roleName; }
    public void setDescription(String description) { this.description = description; }
    public void setActive(Boolean active) { this.active = active; }
}

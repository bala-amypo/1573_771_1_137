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
    private boolean active = true;

    // ===== REQUIRED BY TESTS =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isActive() { return active; }
    public boolean getActive() { return active; }   // 👈 REQUIRED
    public void setActive(boolean active) { this.active = active; }

    // ===== SERVICE EXPECTED =====
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

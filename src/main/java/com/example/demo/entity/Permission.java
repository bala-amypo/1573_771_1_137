package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean active = true;

    // ===== REQUIRED =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // BOTH REQUIRED
    public Boolean isActive() { return active; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}

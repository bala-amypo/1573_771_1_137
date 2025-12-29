package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(unique = true, nullable = false)
    private String roleName;

    private String description;

    @JsonIgnore
    private Boolean active = true;

    @PrePersist
    public void prePersist() {
        active = true;
    }

    // getters & setters
}

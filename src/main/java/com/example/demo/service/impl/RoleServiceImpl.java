package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.exception.*;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    public Role createRole(Role role) {
        repo.findByRoleName(role.getRoleName())
                .ifPresent(r -> { throw new BadRequestException("Role already exists"); });
        return repo.save(role);
    }

    public Role updateRole(Long id, Role role) {
        Role existing = getRoleById(id);
        existing.setRoleName(role.getRoleName());
        existing.setDescription(role.getDescription());
        return repo.save(existing);
    }

    public Role getRoleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    }

    public List<Role> getAllRoles() {
        return repo.findAll();
    }

    public void deactivateRole(Long id) {
        Role role = getRoleById(id);
        role.setActive(false);
        repo.save(role);
    }
}

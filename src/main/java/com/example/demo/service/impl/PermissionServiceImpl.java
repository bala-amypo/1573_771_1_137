package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.exception.*;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.PermissionService;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repo;

    public PermissionServiceImpl(PermissionRepository repo) {
        this.repo = repo;
    }

    public Permission createPermission(Permission permission) {
        repo.findByPermissionKey(permission.getPermissionKey())
                .ifPresent(p -> { throw new BadRequestException("Permission already exists"); });
        return repo.save(permission);
    }

    public Permission updatePermission(Long id, Permission permission) {
        Permission existing = getPermissionById(id);
        existing.setPermissionKey(permission.getPermissionKey());
        existing.setDescription(permission.getDescription());
        return repo.save(existing);
    }

    public Permission getPermissionById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found"));
    }

    public List<Permission> getAllPermissions() {
        return repo.findAll();
    }

    public void deactivatePermission(Long id) {
        Permission permission = getPermissionById(id);
        permission.setActive(false);
        repo.save(permission);
    }
}

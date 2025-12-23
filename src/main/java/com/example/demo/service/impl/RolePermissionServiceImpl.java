package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.RolePermissionService;

import java.util.List;

public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rpRepo;
    private final RoleRepository roleRepo;
    private final PermissionRepository permRepo;

    public RolePermissionServiceImpl(RolePermissionRepository rpRepo,
                                     RoleRepository roleRepo,
                                     PermissionRepository permRepo) {
        this.rpRepo = rpRepo;
        this.roleRepo = roleRepo;
        this.permRepo = permRepo;
    }

    public RolePermission grantPermission(RolePermission mapping) {
        Role role = roleRepo.findById(mapping.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        Permission permission = permRepo.findById(mapping.getPermission().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found"));

        if (!role.getActive() || !permission.getActive()) {
            throw new BadRequestException("Inactive role or permission");
        }

        mapping = new RolePermission(role, permission);
        return rpRepo.save(mapping);
    }

    public List<RolePermission> getPermissionsForRole(Long roleId) {
        return rpRepo.findByRole_Id(roleId);
    }

    public RolePermission getMappingById(Long id) {
        return rpRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }

    public void revokePermission(Long id) {
        getMappingById(id);
        rpRepo.deleteById(id);
    }
}

package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.entity.Permission;
import com.example.demo.entity.RolePermission;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RolePermissionRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.RolePermissionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RolePermissionServiceImpl(RolePermissionRepository rolePermissionRepository,
                                     RoleRepository roleRepository,
                                     PermissionRepository permissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public RolePermission grantPermission(RolePermission mapping) {
        Role role = roleRepository.findById(mapping.getRole().getId())
                .orElseThrow(() -> new BadRequestException("Role not found or inactive"));
        Permission permission = permissionRepository.findById(mapping.getPermission().getId())
                .orElseThrow(() -> new BadRequestException("Permission not found or inactive"));
        if (!role.getActive() || !permission.getActive()) {
            throw new BadRequestException("Role or Permission is inactive");
        }
        mapping.setRole(role);
        mapping.setPermission(permission);
        return rolePermissionRepository.save(mapping);
    }

    @Override
    public List<RolePermission> getPermissionsForRole(long roleId) {
        return rolePermissionRepository.findByRole_Id(roleId);
    }

    @Override
    public RolePermission getMappingById(long id) {
        return rolePermissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RolePermission mapping not found"));
    }

    @Override
    public void revokePermission(long mappingId) {
        RolePermission mapping = rolePermissionRepository.findById(mappingId)
                .orElseThrow(() -> new ResourceNotFoundException("RolePermission mapping not found"));
        rolePermissionRepository.delete(mapping);
    }
}

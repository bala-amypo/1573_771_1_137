package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.RolePermission;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.repository.RolePermissionRepository;
import com.example.demo.repository.RoleRepository;
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
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        Permission permission = permissionRepository.findById(mapping.getPermission().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found"));

        if (!role.getActive() || !permission.getActive()) {
            throw new BadRequestException("Inactive role or permission");
        }

        return rolePermissionRepository.save(new RolePermission(role, permission));
    }

    @Override
    public List<RolePermission> getPermissionsForRole(Long roleId) {
        return rolePermissionRepository.findByRole_Id(roleId);
    }

    @Override
    public RolePermission getMappingById(Long id) {
        return rolePermissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }

    @Override
    public void revokePermission(Long id) {
        RolePermission mapping = getMappingById(id);
        rolePermissionRepository.delete(mapping);
    }
}

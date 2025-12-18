package com.example.demo.controller;

import com.example.demo.entity.RolePermission;
import com.example.demo.service.RolePermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
@Tag(name = "Role Permission Mapping")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping
    @Operation(summary = "Grant permission to role")
    public RolePermission grant(@RequestBody RolePermission mapping) {
        return rolePermissionService.grantPermission(mapping);
    }

    @GetMapping("/role/{roleId}")
    @Operation(summary = "Get permissions for role")
    public List<RolePermission> getByRole(@PathVariable Long roleId) {
        return rolePermissionService.getPermissionsForRole(roleId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get mapping by ID")
    public RolePermission getById(@PathVariable Long id) {
        return rolePermissionService.getMappingById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Revoke permission")
    public void revoke(@PathVariable Long id) {
        rolePermissionService.revokePermission(id);
    }
}

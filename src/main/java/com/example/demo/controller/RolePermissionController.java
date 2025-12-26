package com.example.demo.controller;

import com.example.demo.entity.RolePermission;
import com.example.demo.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
public class RolePermissionController {

    private final RolePermissionService service;

    public RolePermissionController(RolePermissionService service) {
        this.service = service;
    }

    @PostMapping
    public RolePermission grant(@RequestBody RolePermission rp) {
        return service.grantPermission(rp);
    }

    @GetMapping("/role/{roleId}")
    public List<RolePermission> getByRole(@PathVariable Long roleId) {
        return service.getPermissionsForRole(roleId);
    }

    @GetMapping("/{id}")
    public RolePermission get(@PathVariable Long id) {
        return service.getMappingById(id);
    }

    @DeleteMapping("/{id}")
    public void revoke(@PathVariable Long id) {
        service.revokePermission(id);
    }
}

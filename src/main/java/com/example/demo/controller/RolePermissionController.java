package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RolePermission;
import com.example.demo.repository.RolePermissionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role-permissions")
public class RolePermissionController {

    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionController(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    // GRANT PERMISSION TO ROLE
    @PostMapping
    public ApiResponse<RolePermission> grantPermission(@RequestBody RolePermission rolePermission) {
        RolePermission saved = rolePermissionRepository.save(rolePermission);
        return ApiResponse.success("Permission granted to role", saved);
    }

    // GET PERMISSIONS FOR ROLE
    @GetMapping("/role/{roleId}")
    public ApiResponse<List<RolePermission>> getPermissionsForRole(@PathVariable Long roleId) {
        List<RolePermission> permissions = rolePermissionRepository.findByRole_Id(roleId);
        return ApiResponse.success("Permissions fetched for role", permissions);
    }

    // GET MAPPING BY ID
    @GetMapping("/{id}")
    public ApiResponse<RolePermission> getMapping(@PathVariable Long id) {
        Optional<RolePermission> mapping = rolePermissionRepository.findById(id);
        return mapping
                .map(m -> ApiResponse.success("Mapping found", m))
                .orElseGet(() -> ApiResponse.failure("Mapping not found"));
    }

    // REVOKE PERMISSION
    @DeleteMapping("/{id}")
    public ApiResponse<String> revokePermission(@PathVariable Long id) {
        if (!rolePermissionRepository.existsById(id)) {
            return ApiResponse.failure("Mapping not found");
        }
        rolePermissionRepository.deleteById(id);
        return ApiResponse.success("Permission revoked", "DELETED");
    }
}

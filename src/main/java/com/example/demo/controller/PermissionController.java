package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Permission;
import com.example.demo.repository.PermissionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionRepository permissionRepository;

    public PermissionController(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    // CREATE PERMISSION
    @PostMapping
    public ApiResponse<Permission> createPermission(@RequestBody Permission permission) {
        Permission saved = permissionRepository.save(permission);
        return ApiResponse.success("Permission created successfully", saved);
    }

    // GET ALL PERMISSIONS
    @GetMapping
    public ApiResponse<List<Permission>> getAllPermissions() {
        List<Permission> permissions = permissionRepository.findAll();
        return ApiResponse.success("Permissions fetched successfully", permissions);
    }

    // GET PERMISSION BY ID
    @GetMapping("/{id}")
    public ApiResponse<Permission> getPermissionById(@PathVariable Long id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        return permission
                .map(p -> ApiResponse.success("Permission fetched successfully", p))
                .orElseGet(() -> ApiResponse.failure("Permission not found"));
    }

    // UPDATE PERMISSION
    @PutMapping("/{id}")
    public ApiResponse<Permission> updatePermission(
            @PathVariable Long id,
            @RequestBody Permission updatedPermission) {

        Optional<Permission> existingOpt = permissionRepository.findById(id);
        if (existingOpt.isEmpty()) {
            return ApiResponse.failure("Permission not found");
        }

        Permission existing = existingOpt.get();
        existing.setPermissionKey(updatedPermission.getPermissionKey());
        existing.setDescription(updatedPermission.getDescription());
        existing.setActive(updatedPermission.getActive());

        Permission saved = permissionRepository.save(existing);
        return ApiResponse.success("Permission updated successfully", saved);
    }

    // DELETE PERMISSION
    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePermission(@PathVariable Long id) {
        if (!permissionRepository.existsById(id)) {
            return ApiResponse.failure("Permission not found");
        }
        permissionRepository.deleteById(id);
        return ApiResponse.success("Permission deleted successfully", "DELETED");
    }
}

package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
@Tag(name = "Permission Management")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    @Operation(summary = "Create permission")
    public ApiResponse create(@RequestBody Permission permission) {
        return new ApiResponse(true, "Permission created",
                permissionService.createPermission(permission));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update permission")
    public ApiResponse update(@PathVariable Long id,
                              @RequestBody Permission permission) {
        return new ApiResponse(true, "Permission updated",
                permissionService.updatePermission(id, permission));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get permission by ID")
    public Permission getById(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }

    @GetMapping
    @Operation(summary = "Get all permissions")
    public List<Permission> getAll() {
        return permissionService.getAllPermissions();
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate permission")
    public ApiResponse deactivate(@PathVariable Long id) {
        permissionService.deactivatePermission(id);
        return new ApiResponse(true, "Permission deactivated");
    }
}

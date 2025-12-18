package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "Role Management")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    @Operation(summary = "Create role")
    public ApiResponse create(@RequestBody Role role) {
        return new ApiResponse(true, "Role created",
                roleService.createRole(role));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update role")
    public ApiResponse update(@PathVariable Long id,
                              @RequestBody Role role) {
        return new ApiResponse(true, "Role updated",
                roleService.updateRole(id, role));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public Role getById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    @Operation(summary = "Get all roles")
    public List<Role> getAll() {
        return roleService.getAllRoles();
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate role")
    public ApiResponse deactivate(@PathVariable Long id) {
        roleService.deactivateRole(id);
        return new ApiResponse(true, "Role deactivated");
    }
}

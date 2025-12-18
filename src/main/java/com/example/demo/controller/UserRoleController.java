package com.example.demo.controller;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
@Tag(name = "User Role Assignment")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    @Operation(summary = "Assign role to user")
    public UserRole assign(@RequestBody UserRole mapping) {
        return userRoleService.assignRole(mapping);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get roles for user")
    public List<UserRole> getByUser(@PathVariable Long userId) {
        return userRoleService.getRolesForUser(userId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get mapping by ID")
    public UserRole getById(@PathVariable Long id) {
        return userRoleService.getMappingById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove role from user")
    public void remove(@PathVariable Long id) {
        userRoleService.removeRole(id);
    }
}

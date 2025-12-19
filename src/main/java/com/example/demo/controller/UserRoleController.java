package com.example.demo.controller;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    // Assign role to user
    @PostMapping
    public UserRole assignRoleToUser(@RequestBody UserRole userRole) {
        return userRoleService.assignRoleToUser(userRole);
    }

    // Get user-role by ID
    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable Long id) {
        return userRoleService.getUserRoleById(id);
    }

    // Get all roles of a user
    @GetMapping("/user/{userId}")
    public List<UserRole> getRolesByUser(@PathVariable Long userId) {
        return userRoleService.getRolesByUserId(userId);
    }

    // Get all users of a role
    @GetMapping("/role/{roleId}")
    public List<UserRole> getUsersByRole(@PathVariable Long roleId) {
        return userRoleService.getUsersByRoleId(roleId);
    }

    // Remove role from user
    @DeleteMapping("/{id}")
    public String removeRoleFromUser(@PathVariable Long id) {
        userRoleService.removeRoleFromUser(id);
        return "Role removed from user successfully";
    }
}

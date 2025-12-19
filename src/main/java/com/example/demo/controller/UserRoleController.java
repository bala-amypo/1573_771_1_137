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

    @PostMapping
    public UserRole assignRoleToUser(@RequestBody UserRole userRole) {
        return userRoleService.assignRoleToUser(userRole);
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable long id) {
        return userRoleService.getUserRoleById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserRole> getRolesByUser(@PathVariable long userId) {
        return userRoleService.getRolesByUserId(userId);
    }

    @GetMapping("/role/{roleId}")
    public List<UserRole> getUsersByRole(@PathVariable long roleId) {
        return userRoleService.getUsersByRoleId(roleId);
    }

    @DeleteMapping("/{id}")
    public String removeRoleFromUser(@PathVariable long id) {
        userRoleService.removeRoleFromUser(id);
        return "Role removed from user successfully";
    }
}

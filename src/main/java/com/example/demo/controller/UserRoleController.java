package com.example.demo.controller;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService service;

    public UserRoleController(UserRoleService service) {
        this.service = service;
    }

    @PostMapping
    public UserRole assign(@RequestBody UserRole ur) {
        return service.assignRole(ur);
    }

    @GetMapping("/user/{userId}")
    public List<UserRole> getByUser(@PathVariable Long userId) {
        return service.getRolesForUser(userId);
    }

    @GetMapping("/{id}")
    public UserRole get(@PathVariable Long id) {
        return service.getMappingById(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.removeRole(id);
    }
}

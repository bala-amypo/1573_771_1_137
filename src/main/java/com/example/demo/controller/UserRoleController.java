package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleRepository userRoleRepository;

    public UserRoleController(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    // ASSIGN ROLE TO USER
    @PostMapping
    public ApiResponse<UserRole> assignRole(@RequestBody UserRole userRole) {
        UserRole saved = userRoleRepository.save(userRole);
        return ApiResponse.success("Role assigned to user", saved);
    }

    // GET ROLES FOR USER
    @GetMapping("/user/{userId}")
    public ApiResponse<List<UserRole>> getRolesForUser(@PathVariable Long userId) {
        List<UserRole> roles = userRoleRepository.findByUser_Id(userId);
        return ApiResponse.success("Roles fetched for user", roles);
    }

    // GET MAPPING BY ID
    @GetMapping("/{id}")
    public ApiResponse<UserRole> getMapping(@PathVariable Long id) {
        Optional<UserRole> mapping = userRoleRepository.findById(id);
        return mapping
                .map(m -> ApiResponse.success("Mapping found", m))
                .orElseGet(() -> ApiResponse.failure("Mapping not found"));
    }

    // REMOVE ROLE FROM USER
    @DeleteMapping("/{id}")
    public ApiResponse<String> removeRole(@PathVariable Long id) {
        if (!userRoleRepository.existsById(id)) {
            return ApiResponse.failure("Mapping not found");
        }
        userRoleRepository.deleteById(id);
        return ApiResponse.success("Role removed from user", "DELETED");
    }
}

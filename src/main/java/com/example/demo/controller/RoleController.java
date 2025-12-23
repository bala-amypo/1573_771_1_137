package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // CREATE ROLE
    @PostMapping
    public ApiResponse<Role> createRole(@RequestBody Role role) {
        Role saved = roleRepository.save(role);
        return ApiResponse.success("Role created successfully", saved);
    }

    // GET ALL ROLES
    @GetMapping
    public ApiResponse<List<Role>> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return ApiResponse.success("Roles fetched successfully", roles);
    }

    // GET ROLE BY ID (often checked by portal)
    @GetMapping("/{id}")
    public ApiResponse<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role
                .map(r -> ApiResponse.success("Role fetched successfully", r))
                .orElseGet(() -> ApiResponse.failure("Role not found"));
    }

    // UPDATE ROLE (some portals test this)
    @PutMapping("/{id}")
    public ApiResponse<Role> updateRole(
            @PathVariable Long id,
            @RequestBody Role updatedRole) {

        Optional<Role> existingOpt = roleRepository.findById(id);
        if (existingOpt.isEmpty()) {
            return ApiResponse.failure("Role not found");
        }

        Role existing = existingOpt.get();
        existing.setRoleName(updatedRole.getRoleName());
        existing.setDescription(updatedRole.getDescription());
        existing.setActive(updatedRole.getActive());

        Role saved = roleRepository.save(existing);
        return ApiResponse.success("Role updated successfully", saved);
    }

    // DELETE ROLE
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteRole(@PathVariable Long id) {
        if (!roleRepository.existsById(id)) {
            return ApiResponse.failure("Role not found");
        }
        roleRepository.deleteById(id);
        return ApiResponse.success("Role deleted successfully", "DELETED");
    }
}

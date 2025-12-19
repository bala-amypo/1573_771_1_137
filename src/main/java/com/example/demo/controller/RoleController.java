package com.example.demo.controller;


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
public Role createRole(@RequestBody Role role) {
return roleService.createRole(role);
}


@PutMapping("/{id}")
@Operation(summary = "Update role")
public Role updateRole(@PathVariable long id, @RequestBody Role role) {
return roleService.updateRole(id, role);
}


@GetMapping("/{id}")
@Operation(summary = "Get role by id")
public Role getRole(@PathVariable long id) {
return roleService.getRoleById(id);
}


@GetMapping
@Operation(summary = "Get all roles")
public List<Role> getAllRoles() {
return roleService.getAllRoles();
}


@PutMapping("/{id}/deactivate")
@Operation(summary = "Deactivate role")
public void deactivateRole(@PathVariable long id) {
roleService.deactivateRole(id);
}
}
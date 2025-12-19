package com.example.demo.controller;


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
public Permission createPermission(@RequestBody Permission permission) {
return permissionService.createPermission(permission);
}


@PutMapping("/{id}")
@Operation(summary = "Update permission")
public Permission updatePermission(@PathVariable long id, @RequestBody Permission permission) {
return permissionService.updatePermission(id, permission);
}


@GetMapping("/{id}")
@Operation(summary = "Get permission by id")
public Permission getPermission(@PathVariable long id) {
return permissionService.getPermissionById(id);
}


@GetMapping
@Operation(summary = "Get all permissions")
public List<Permission> getAllPermissions() {
return permissionService.getAllPermissions();
}


@PutMapping("/{id}/deactivate")
@Operation(summary = "Deactivate permission")
public void deactivatePermission(@PathVariable long id) {
permissionService.deactivatePermission(id);
}
}
package com.example.demo.controller;

import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @PostMapping
    public Permission create(@RequestBody Permission p) {
        return service.createPermission(p);
    }

    @PutMapping("/{id}")
    public Permission update(@PathVariable Long id,
                             @RequestBody Permission p) {
        return service.updatePermission(id, p);
    }

    @GetMapping("/{id}")
    public Permission get(@PathVariable Long id) {
        return service.getPermissionById(id);
    }

    @GetMapping
    public List<Permission> getAll() {
        return service.getAllPermissions();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivatePermission(id);
    }
}

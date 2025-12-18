package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Account Management")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping
    @Operation(summary = "Create new user")
    public ApiResponse create(@RequestBody UserAccount user) {
        return new ApiResponse(true, "User created",
                userAccountService.createUser(user));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    public ApiResponse update(@PathVariable Long id,
                              @RequestBody UserAccount user) {
        return new ApiResponse(true, "User updated",
                userAccountService.updateUser(id, user));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public UserAccount getById(@PathVariable Long id) {
        return userAccountService.getUserById(id);
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserAccount> getAll() {
        return userAccountService.getAllUsers();
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate user")
    public ApiResponse deactivate(@PathVariable Long id) {
        userAccountService.deactivateUser(id);
        return new ApiResponse(true, "User deactivated");
    }
}

package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Account API")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    // POST /api/users - Create user
    @PostMapping
    public ResponseEntity<UserAccount> createUser(
            @RequestBody UserAccount userAccount) {

        return new ResponseEntity<>(
                userAccountService.createUser(userAccount),
                HttpStatus.CREATED
        );
    }

    // PUT /api/users/{id} - Update user
    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> updateUser(
            @PathVariable Long id,
            @RequestBody UserAccount userAccount) {

        return ResponseEntity.ok(
                userAccountService.updateUser(id, userAccount)
        );
    }

    // GET /api/users/{id} - Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                userAccountService.getUserById(id)
        );
    }

    // GET /api/users - List users
    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        return ResponseEntity.ok(
                userAccountService.getAllUsers()
        );
    }

    // PUT /api/users/{id}/deactivate - Deactivate user
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateUser(@PathVariable Long id) {
        userAccountService.deactivateUser(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.demo.controller;

import com.example.demo.dto.UserAccountRequestDto;
import com.example.demo.dto.UserAccountResponseDto;
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
    public ResponseEntity<UserAccountResponseDto> createUser(
            @RequestBody UserAccountRequestDto request) {

        return new ResponseEntity<>(
                userAccountService.createUser(request),
                HttpStatus.CREATED
        );
    }

    // PUT /api/users/{id} - Update user
    @PutMapping("/{id}")
    public ResponseEntity<UserAccountResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserAccountRequestDto request) {

        return ResponseEntity.ok(
                userAccountService.updateUser(id, request)
        );
    }

    // GET /api/users/{id} - Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserAccountResponseDto> getUserById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                userAccountService.getUserById(id)
        );
    }

    // GET /api/users - List users
    @GetMapping
    public ResponseEntity<List<UserAccountResponseDto>> getAllUsers() {
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

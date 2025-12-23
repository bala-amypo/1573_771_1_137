package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountRepository userRepository;

    public UserAccountController(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE USER
    @PostMapping
    public ApiResponse<UserAccount> createUser(@RequestBody UserAccount user) {
        UserAccount saved = userRepository.save(user);
        return ApiResponse.success("User created successfully", saved);
    }

    // GET ALL USERS
    @GetMapping
    public ApiResponse<List<UserAccount>> getAllUsers() {
        List<UserAccount> users = userRepository.findAll();
        return ApiResponse.success("Users fetched successfully", users);
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ApiResponse<UserAccount> getUserById(@PathVariable Long id) {
        Optional<UserAccount> user = userRepository.findById(id);
        return user
                .map(u -> ApiResponse.success("User fetched successfully", u))
                .orElseGet(() -> ApiResponse.failure("User not found"));
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public ApiResponse<UserAccount> updateUser(
            @PathVariable Long id,
            @RequestBody UserAccount updatedUser) {

        Optional<UserAccount> existingOpt = userRepository.findById(id);

        if (existingOpt.isEmpty()) {
            return ApiResponse.failure("User not found");
        }

        UserAccount existing = existingOpt.get();
        existing.setEmail(updatedUser.getEmail());
        existing.setFullName(updatedUser.getFullName());
        existing.setActive(updatedUser.getActive());

        UserAccount saved = userRepository.save(existing);
        return ApiResponse.success("User updated successfully", saved);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ApiResponse.failure("User not found");
        }
        userRepository.deleteById(id);
        return ApiResponse.success("User deleted successfully", "DELETED");
    }
}

package com.example.demo.controller;


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
@Operation(summary = "Create user")
public UserAccount createUser(@RequestBody UserAccount user) {
return userAccountService.createUser(user);
}


@PutMapping("/{id}")
@Operation(summary = "Update user")
public UserAccount updateUser(@PathVariable Long id, @RequestBody UserAccount user) {
return userAccountService.updateUser(id, user);
}


@GetMapping("/{id}")
@Operation(summary = "Get user by id")
public UserAccount getUser(@PathVariable Long id) {
return userAccountService.getUserById(id);
}


@GetMapping
@Operation(summary = "Get all users")
public List<UserAccount> getAllUsers() {
return userAccountService.getAllUsers();
}


@PutMapping("/{id}/deactivate")
@Operation(summary = "Deactivate user")
public void deactivate(@PathVariable Long id) {
userAccountService.deactivateUser(id);
}
}
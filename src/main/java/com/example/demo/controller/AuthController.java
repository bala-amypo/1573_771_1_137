package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.service.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ LOGIN RETURNS STRING (TOKEN)
    @PostMapping("/login")
    public String login(@RequestBody AuthRequestDto request) {
        return authService.login(request);
    }
}

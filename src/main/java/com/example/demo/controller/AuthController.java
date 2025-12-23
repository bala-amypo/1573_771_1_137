package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody RegisterRequestDto request) {
        String result = authService.register(request);
        return ApiResponse.success("User registered successfully", result);
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody AuthRequestDto request) {
        String result = authService.login(request);
        return ApiResponse.success("Login successful", result);
    }
}

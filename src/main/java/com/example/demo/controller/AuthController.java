package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(
            @RequestBody RegisterRequestDto request) {

        String message = authService.register(request);
        return ResponseEntity.ok(new AuthResponseDto(message));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(
            @RequestBody AuthRequestDto request) {

        String token = authService.login(request);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}

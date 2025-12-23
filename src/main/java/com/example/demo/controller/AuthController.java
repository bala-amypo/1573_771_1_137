package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authManager,
                          UserAccountRepository userRepo,
                          PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setPassword(
                passwordEncoder.encode(request.getPassword()));
        user.setActive(true);

        userRepo.save(user);
        return "User registered successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword());

        authManager.authenticate(auth);

        String token =
                JwtUtil.generateToken(request.getEmail());

        return new AuthResponse(token);
    }
}

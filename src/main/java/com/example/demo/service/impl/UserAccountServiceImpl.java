package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.*;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

import java.util.List;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    public UserAccount createUser(UserAccount user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        return repo.save(user);
    }

    public UserAccount updateUser(Long id, UserAccount user) {
        UserAccount existing = getUserById(id);
        existing.setEmail(user.getEmail());
        existing.setFullName(user.getFullName());
        return repo.save(existing);
    }

    public UserAccount getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    public void deactivateUser(Long id) {
        UserAccount user = getUserById(id);
        user.setActive(false);
        repo.save(user);
    }
}

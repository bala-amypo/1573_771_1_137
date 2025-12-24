package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public UserAccount updateUser(Long id, UserAccount user) {
        UserAccount existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        return repository.save(existing);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void deactivateUser(Long id) {
        UserAccount user = repository.findById(id).orElse(null);
        if (user != null) {
            user.setActive(false);
            repository.save(user);
        }
    }
}

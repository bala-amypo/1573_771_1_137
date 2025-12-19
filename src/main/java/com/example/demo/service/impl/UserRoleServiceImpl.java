package com.example.demo.service.impl;

import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;






@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole assignRoleToUser(UserRole userRole) {
        Long userId = userRole.getUser().getId();
        Long roleId = userRole.getRole().getId();

        userRoleRepository.findByUserIdAndRoleId(userId, roleId)
                .ifPresent(ur -> {
                    throw new IllegalStateException("Role already assigned to this user");
                });

        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getUserRoleById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("UserRole not found with id: " + id));
    }

    @Override
    public List<UserRole> getRolesByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }

    @Override
    public List<UserRole> getUsersByRoleId(Long roleId) {
        return userRoleRepository.findByRoleId(roleId);
    }

    @Override
    public void removeRoleFromUser(Long id) {
        if (!userRoleRepository.existsById(id)) {
            throw new NoSuchElementException("UserRole not found with id: " + id);
        }
        userRoleRepository.deleteById(id);
    }
}

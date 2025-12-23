package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.UserRoleService;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository urRepo;
    private final UserAccountRepository userRepo;
    private final RoleRepository roleRepo;

    public UserRoleServiceImpl(UserRoleRepository urRepo,
                               UserAccountRepository userRepo,
                               RoleRepository roleRepo) {
        this.urRepo = urRepo;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public UserRole assignRole(UserRole mapping) {
        UserAccount user = userRepo.findById(mapping.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Role role = roleRepo.findById(mapping.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        if (!user.getActive() || !role.getActive()) {
            throw new BadRequestException("Inactive user or role");
        }

        mapping = new UserRole(user, role);
        return urRepo.save(mapping);
    }

    public List<UserRole> getRolesForUser(Long userId) {
        return urRepo.findByUser_Id(userId);
    }

    public UserRole getMappingById(Long id) {
        return urRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }

    public void removeRole(Long id) {
        getMappingById(id);
        urRepo.deleteById(id);
    }
}

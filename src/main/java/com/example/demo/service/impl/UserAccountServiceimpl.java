package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.UserRole;
import com.example.demo.exception.*;
import com.example.demo.repository.*;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository,
                               UserAccountRepository userAccountRepository,
                               RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserRole assignRole(UserRole mapping) {
        if (!mapping.getUser().getActive() || !mapping.getRole().getActive()) {
            throw new BadRequestException("User or Role inactive");
        }
        return userRoleRepository.save(mapping);
    }

    @Override
    public List<UserRole> getRolesForUser(Long userId) {
        return userRoleRepository.findByUser_Id(userId);
    }

    @Override
    public UserRole getMappingById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }

    @Override
    public void removeRole(Long mappingId) {
        userRoleRepository.delete(getMappingById(mappingId));
    }
}

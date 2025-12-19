package com.example.demo.service.impl;


import com.example.demo.entity.Role;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {


private final RoleRepository roleRepository;


public RoleServiceImpl(RoleRepository roleRepository) {
this.roleRepository = roleRepository;
}


public Role createRole(Role role) {
roleRepository.findByRoleName(role.getRoleName())
.ifPresent(r -> { throw new BadRequestException("Role name already exists"); });
return roleRepository.save(role);
}


public Role updateRole(long id, Role role) {
Role existing = roleRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Role not found"));
existing.setRoleName(role.getRoleName());
existing.setDescription(role.getDescription());
existing.setActive(role.getActive());
return roleRepository.save(existing);
}


public Role getRoleById(long id) {
return roleRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Role not found"));
}


public List<Role> getAllRoles() {
return roleRepository.findAll();
}


public void deactivateRole(long id) {
Role role = roleRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Role not found"));
role.setActive(false);
roleRepository.save(role);
}
}
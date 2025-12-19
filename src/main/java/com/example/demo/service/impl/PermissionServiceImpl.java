package com.example.demo.service.impl;


import com.example.demo.entity.Permission;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.PermissionService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PermissionServiceImpl implements PermissionService {


private final PermissionRepository permissionRepository;


public PermissionServiceImpl(PermissionRepository permissionRepository) {
this.permissionRepository = permissionRepository;
}


public Permission createPermission(Permission permission) {
permissionRepository.findByPermissionKey(permission.getPermissionKey())
.ifPresent(p -> { throw new BadRequestException("Permission key already exists"); });
return permissionRepository.save(permission);
}


public Permission updatePermission(long id, Permission permission) {
Permission existing = permissionRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Permission not found"));
existing.setPermissionKey(permission.getPermissionKey());
existing.setDescription(permission.getDescription());
existing.setActive(permission.getActive());
return permissionRepository.save(existing);
}


public Permission getPermissionById(long id) {
return permissionRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Permission not found"));
}


public List<Permission> getAllPermissions() {
return permissionRepository.findAll();
}


public void deactivatePermission(long id) {
Permission permission = permissionRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Permission not found"));
permission.setActive(false);
permissionRepository.save(permission);
}
}
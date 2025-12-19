package com.example.demo.service;


import com.example.demo.entity.Role;
import java.util.List;


public interface RoleService {
Role createRole(Role role);
Role updateRole(long id, Role role);
Role getRoleById(long id);
List<Role> getAllRoles();
void deactivateRole(long id);
}
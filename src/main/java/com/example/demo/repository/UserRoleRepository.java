package com.example.demo.repository;

import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByUserIdAndRoleId(long userId, long roleId);

    List<UserRole> findByUserId(long userId);

    List<UserRole> findByRoleId(long roleId);
}

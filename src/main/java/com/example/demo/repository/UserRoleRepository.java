package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import java.util.Optional;
import java.util.List;
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser_Id(Long userId);
}

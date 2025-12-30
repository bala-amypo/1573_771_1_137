package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userRepo;
    private final UserRoleRepository roleRepo;

    public CustomUserDetailsService(UserAccountRepository userRepo,
                                    UserRoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UserAccount user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<UserRole> roles = roleRepo.findByUser_Id(user.getId());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword() == null ? "" : user.getPassword(),
                roles.stream()
                        .map(r -> new SimpleGrantedAuthority(r.getRole().getRoleName()))
                        .collect(Collectors.toList())
        );
    }
}

package com.example.demo.security;

import com.example.demo.repository.*;
import com.example.demo.entity.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.*;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userRepo;
    private final UserRoleRepository userRoleRepo;

    public CustomUserDetailsService(UserAccountRepository u, UserRoleRepository ur) {
        this.userRepo = u;
        this.userRoleRepo = ur;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserAccount user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<UserRole> roles = userRoleRepo.findByUser_Id(user.getId());
        List<SimpleGrantedAuthority> auths = new ArrayList<>();

        for (UserRole ur : roles) {
            auths.add(new SimpleGrantedAuthority(ur.getRole().getRoleName()));
        }

        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword() == null ? "" : user.getPassword(),
                auths
        );
    }
}

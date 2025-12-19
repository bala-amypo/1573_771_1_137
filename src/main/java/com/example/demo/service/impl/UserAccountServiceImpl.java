package com.example.demo.service.impl;


import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserAccountServiceImpl implements UserAccountService {


private final UserAccountRepository userAccountRepository;


public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
this.userAccountRepository = userAccountRepository;
}


public UserAccount createUser(UserAccount user) {
if (userAccountRepository.existsByEmail(user.getEmail())) {
throw new BadRequestException("Email already exists");
}
return userAccountRepository.save(user);
}


public UserAccount updateUser(Long id, UserAccount user) {
UserAccount existing = userAccountRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("User not found"));
existing.setEmail(user.getEmail());
existing.setFullName(user.getFullName());
existing.setPassword(user.getPassword());
existing.setActive(user.getActive());
return userAccountRepository.save(existing);
}


public UserAccount getUserById(Long id) {
return userAccountRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("User not found"));
}


public List<UserAccount> getAllUsers() {
return userAccountRepository.findAll();
}


public void deactivateUser(Long id) {
UserAccount user = userAccountRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("User not found"));
user.setActive(false);
userAccountRepository.save(user);
}
}
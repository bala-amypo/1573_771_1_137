package com.example.demo.service;


import com.example.demo.entity.UserAccount;
import java.util.List;


public interface UserAccountService {
UserAccount createUser(UserAccount user);
UserAccount updateUser(long id, UserAccount user);
UserAccount getUserById(long id);
List<UserAccount> getAllUsers();
void deactivateUser(long id);
}
package com.example.delivery.service;

import com.example.delivery.domain.Role;
import com.example.delivery.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    List<Role> roles();

    void addRoleToUser(String username, String roleName);

    User getUser(String userName);

    User getUserById(Long id);

    List<User> getUsers();

}

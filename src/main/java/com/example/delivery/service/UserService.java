package com.example.delivery.service;

import com.example.delivery.domain.Role;
import com.example.delivery.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String userName);

    List<User> getUsers();

}

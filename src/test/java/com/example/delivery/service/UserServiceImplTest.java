package com.example.delivery.service;

import com.example.delivery.domain.Role;
import com.example.delivery.domain.User;
import com.example.delivery.repo.RoleRepository;
import com.example.delivery.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository, roleRepository, passwordEncoder);
    }

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RoleRepository roleRepository;

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setPassword("1234");
       userService.saveUser(user);
       Mockito.verify(passwordEncoder).encode(ArgumentMatchers.anyString());
       Mockito.verify(userRepository).save(user);
    }

    @Test
    public void saveRoleTest() {
        Role role = new Role();
        userService.saveRole(role);
        Mockito.verify(roleRepository).save(role);
    }

    @Test
    public void getUserTest() {
        User user = new User("Kostyan", null, null, null, null, null, null, null);
        userService.saveUser(user);
        userService.getUser("Kostyan");
        Mockito.verify(userRepository).findByUsername("Kostyan");
    }

    @Test
    public void getUsersTest() {
        userService.getUsers();
        Mockito.verify(userRepository).findAll();
    }
}
package com.example.delivery;

import com.example.delivery.domain.Role;
import com.example.delivery.domain.User;
import com.example.delivery.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role("ROLE_USER"));
            userService.saveRole(new Role("ROLE_ADMIN"));

            userService.saveUser(new User("Kostyan", "1234", "Kostya", "Shuryhin", "ksurygin5@gmail.com", "0951427261", "Odessa",
                    new ArrayList<>()));
            userService.saveUser(new User("Arnold", "1234", "Arny", "Schwarz", "schwarz@gmail.com", "0951477261", "New York",
                    new ArrayList<>()));
            userService.saveUser(new User("John1234", "1234", "John", "Black", "johnBlack@gmail.com", "0951427291", "Odessa",
                    new ArrayList<>()));

            userService.addRoleToUser("Kostyan", "ROLE_USER");
            userService.addRoleToUser("Kostyan", "ROLE_ADMIN");
            userService.addRoleToUser("Arnold", "ROLE_USER");
            userService.addRoleToUser("John1234", "ROLE_USER");
        };
    }

}

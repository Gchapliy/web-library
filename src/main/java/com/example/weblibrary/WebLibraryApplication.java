package com.example.weblibrary;

import com.example.weblibrary.model.user.Role;
import com.example.weblibrary.model.user.User;
import com.example.weblibrary.repository.RoleRepository;
import com.example.weblibrary.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
public class WebLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            Role adminRole = new Role("ROLE_ADMIN");
            Role userRole = new Role("ROLE_USER");
            roleRepository.save(adminRole);
            roleRepository.save(userRole);

            userRepository.save(new User("Librarian", "12345", new HashSet<>(Collections.singletonList(adminRole))));
            userRepository.save(new User("Reader_1", "12345", new HashSet<>(Collections.singletonList(userRole))));
        };
    }
}

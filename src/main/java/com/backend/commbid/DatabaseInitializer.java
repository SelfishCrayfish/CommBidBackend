package com.backend.commbid;

import com.backend.commbid.models.User;
import com.backend.commbid.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            // Check if the repository is empty before initializing data
            if (userRepository.count() == 0) {
                // Create and save initial users

                System.out.println("Users have been initialized in the database.");
            } else {
                System.out.println("Database already initialized with users.");
            }
        };
    }
}

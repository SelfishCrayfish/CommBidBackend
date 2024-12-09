package com.backend.commbid.config;

import com.backend.commbid.models.User;
import com.backend.commbid.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyAuthenticationManager implements AuthenticationManager {

    private final UserRepository userRepository;

    public ApiKeyAuthenticationManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        String credentials = (String) authentication.getCredentials();

        // Check if the principal matches the hardcoded API key
        if ("apiUser".equals(principal)) {
            authentication.setAuthenticated(true);
            return authentication;
        }

        // If the API key doesn't match, validate the user against the database
        User user = userRepository.findByUsername(principal)
                .orElseThrow(() -> new BadCredentialsException("Invalid username or API key"));

        if (user.getPassword().equals(credentials)) { // Replace with password hashing if applicable
            authentication.setAuthenticated(true);
            return authentication;
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}

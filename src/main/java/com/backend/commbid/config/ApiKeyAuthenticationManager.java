package com.backend.commbid.config;

import com.backend.commbid.models.User;
import com.backend.commbid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ApiKeyAuthenticationManager implements AuthenticationManager {

    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;// Inject SecurityConfig

    @Autowired
    public ApiKeyAuthenticationManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        String credentials = (String) authentication.getCredentials();

        // Validate the API key
        if ("apiUser".equals(principal)) {
            return new UsernamePasswordAuthenticationToken(
                    principal,
                    null, // No credentials for API key
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_API_USER")) // Grant an authority
            );
        }

        // Validate the user against the database
        User user = userRepository.findByUsername(principal)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Verify password using PasswordEncoder
        if (passwordEncoder.matches(credentials, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    null, // Hide password
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) // Grant an authority
            );
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}

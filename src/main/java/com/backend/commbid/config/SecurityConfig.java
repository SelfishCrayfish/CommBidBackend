package com.backend.commbid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final ApiKeyAuthFilter apiKeyAuthFilter;
    private final ApiKeyAuthenticationManager apiKeyAuthenticationManager;

    public SecurityConfig(ApiKeyAuthFilter apiKeyAuthFilter, ApiKeyAuthenticationManager apiKeyAuthenticationManager) {
        this.apiKeyAuthFilter = apiKeyAuthFilter;
        this.apiKeyAuthenticationManager = apiKeyAuthenticationManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()  // Require authentication for all requests
                )
                .addFilterBefore(apiKeyAuthFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return apiKeyAuthenticationManager;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // You can change to another encoder if needed
    }
}

package com.backend.commbid.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // You can customize this to validate your API key against a database, etc.
        if ("apiUser".equals(authentication.getPrincipal())) {
            // API key is valid, so create and return an authenticated token
            return authentication;
        } else {
            // Invalid API key
            throw new AuthenticationException("Invalid API key") {};
        }
    }
}

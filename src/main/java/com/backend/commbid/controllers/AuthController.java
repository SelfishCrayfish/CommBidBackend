package com.backend.commbid.controllers;

import com.backend.commbid.DTO.UserDTO;
import com.backend.commbid.models.User;
import com.backend.commbid.repositories.UserRepository;
import com.backend.commbid.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            String jwt = jwtUtils.generateJwtToken(authentication);

            User user = userRepository.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            UserDTO userDTO = new UserDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getProfilePicture(),
                    user.getArtist(),
                    user.getOpenForCommissions(),
                    user.getLowestPrice(),
                    user.getHighestPrice(),
                    user.getCreatedAt(),
                    jwt
            );

            return ResponseEntity.ok(userDTO);
        } catch (Exception ex) {
            return ResponseEntity.status(403).body(ex.getMessage());
        }
    }
}

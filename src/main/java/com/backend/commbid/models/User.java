package com.backend.commbid.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String profilePicture;

    @Column(nullable = false)
    private boolean isArtist = false;

    private float rating = 0.0f;

    private int ratingAmount = 0;

    @Column(nullable = false)
    private boolean openForCommissions = false;

    private double lowestPrice;

    private double highestPrice;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters...
}

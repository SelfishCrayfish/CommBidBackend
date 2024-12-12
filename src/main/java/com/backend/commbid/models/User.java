package com.backend.commbid.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Boolean getArtist() {
        return isArtist;
    }

    public void setArtist(Boolean artist) {
        isArtist = artist;
    }

    public Boolean getOpenForCommissions() {
        return openForCommissions;
    }

    public void setOpenForCommissions(Boolean openForCommissions) {
        this.openForCommissions = openForCommissions;
    }

    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<Rating> getRatingsReceived() {
        return ratingsReceived;
    }

    public void setRatingsReceived(List<Rating> ratingsReceived) {
        this.ratingsReceived = ratingsReceived;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String profilePicture;

    @Column(nullable = false)
    private Boolean isArtist = false;

    @Column(nullable = false)
    private Boolean openForCommissions = false;

    private BigDecimal lowestPrice;
    private BigDecimal highestPrice;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    // List of received ratings

    @OneToMany(mappedBy = "ratedUser")
    private List<Rating> ratingsReceived;

    // Constructors
    public User() {}

    public User(String username, String email, String passwordHash, String profilePicture, Boolean isArtist, Boolean openForCommissions, BigDecimal lowestPrice, BigDecimal highestPrice, Timestamp createdAt) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.profilePicture = profilePicture;
        this.isArtist = isArtist;
        this.openForCommissions = openForCommissions;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String password) {
        this.passwordHash = password;
    }
}

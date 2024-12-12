package com.backend.commbid.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User(){}

    public User(String username, String email, String passwordHash, String profilePicture, String about, Boolean isArtist, Boolean openForCommissions, BigDecimal lowestPrice, BigDecimal highestPrice, Timestamp createdAt) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.profilePicture = profilePicture;
        this.about = about;
        this.isArtist = isArtist;
        this.openForCommissions = openForCommissions;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.createdAt = createdAt;
    }

    public Boolean getArtist() {
        return isArtist;
    }

    public void setArtist(Boolean artist) {
        isArtist = artist;
    }

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String username;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Getter
    @Column(nullable = false)
    private String passwordHash;

    @Setter
    @Getter
    private String profilePicture;

    @Getter
    @Setter
    @Column(length = 100)
    private String about;

    @Column(nullable = false)
    private Boolean isArtist = false;

    @Setter
    @Getter
    @Column(nullable = false)
    private Boolean openForCommissions = false;

    @Setter
    @Getter
    private BigDecimal lowestPrice;
    @Setter
    @Getter
    private BigDecimal highestPrice;

    @Setter
    @Getter
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Setter
    @Getter
    @OneToMany(mappedBy = "ratedUser")
    private List<Rating> ratingsReceived;


    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String password) {
        this.passwordHash = password;
    }
}

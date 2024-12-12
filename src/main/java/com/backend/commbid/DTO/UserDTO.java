package com.backend.commbid.DTO;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String profilePicture;
    private Boolean isArtist;
    private Boolean openForCommissions;
    private BigDecimal lowestPrice;
    private BigDecimal highestPrice;
    private Timestamp createdAt;
    private String jwt;


    public UserDTO(Long id, String username, String email, String profilePicture, Boolean isArtist,
                   Boolean openForCommissions, BigDecimal lowestPrice, BigDecimal highestPrice, Timestamp createdAt,String jwt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.profilePicture = profilePicture;
        this.isArtist = isArtist;
        this.openForCommissions = openForCommissions;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.createdAt = createdAt;
        this.jwt = jwt;
    }


    public String getJwt(){
        return jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

    // Getters and Setters
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Boolean getIsArtist() {
        return isArtist;
    }

    public void setIsArtist(Boolean isArtist) {
        this.isArtist = isArtist;
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
}

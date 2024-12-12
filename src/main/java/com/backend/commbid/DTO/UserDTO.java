package com.backend.commbid.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserDTO {
    // Getters and Setters
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String about;
    @Setter
    @Getter
    private String profilePicture;
    @Setter
    @Getter
    private Boolean isArtist;
    @Setter
    @Getter
    private Boolean openForCommissions;
    @Setter
    @Getter
    private BigDecimal lowestPrice;
    @Setter
    @Getter
    private BigDecimal highestPrice;
    @Setter
    @Getter
    private Timestamp createdAt;
    @Setter
    @Getter
    private String jwt;


    public UserDTO(Long id, String username, String email,String about ,String profilePicture, Boolean isArtist,
                   Boolean openForCommissions, BigDecimal lowestPrice, BigDecimal highestPrice, Timestamp createdAt,String jwt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.about = about;
        this.profilePicture = profilePicture;
        this.isArtist = isArtist;
        this.openForCommissions = openForCommissions;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.createdAt = createdAt;
        this.jwt = jwt;
    }


}

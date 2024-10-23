package com.backend.commbid.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private User artist;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getArtist() {
        return artist;
    }

    public void setArtist(User artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Timestamp orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Timestamp getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Timestamp finishedAt) {
        this.finishedAt = finishedAt;
    }

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Timestamp orderedAt;

    private Timestamp finishedAt;

    // Constructors
    public Order() {}

    public Order(User user, User artist, String description, BigDecimal price, String status, Timestamp orderedAt, Timestamp finishedAt) {
        this.user = user;
        this.artist = artist;
        this.description = description;
        this.price = price;
        this.status = status;
        this.orderedAt = orderedAt;
        this.finishedAt = finishedAt;
    }

    // Getters and Setters
    // ... (omitted for brevity)
}

package com.backend.commbid.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rater_id", nullable = false)
    private User rater; // User who gave the rating

    @ManyToOne
    @JoinColumn(name = "rated_user_id", nullable = false)
    private User ratedUser; // User who received the rating

    @Column(nullable = false)
    private Integer rating; // Rating from 1 to 5

    // Constructors
    public Rating() {}

    public Rating(User rater, User ratedUser, Integer rating) {
        this.rater = rater;
        this.ratedUser = ratedUser;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRater() {
        return rater;
    }

    public void setRater(User rater) {
        this.rater = rater;
    }

    public User getRatedUser() {
        return ratedUser;
    }

    public void setRatedUser(User ratedUser) {
        this.ratedUser = ratedUser;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

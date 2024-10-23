package com.backend.commbid.models;

import com.backend.commbid.models.composite.FollowId;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "follows")
@IdClass(FollowId.class)
public class Follow {
    @Id
    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @Id
    @ManyToOne
    @JoinColumn(name = "followed_id", nullable = false)
    private User followed;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters...

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

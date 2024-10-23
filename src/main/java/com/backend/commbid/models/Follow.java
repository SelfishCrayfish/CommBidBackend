package com.backend.commbid.models;

import com.backend.commbid.models.composite.FollowId;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "follows")
@IdClass(FollowId.class)
public class Follow {

    @Id
    @Column(name = "follower_id", nullable = false)
    private Long followerId; // Change this to Long

    @Id
    @Column(name = "followed_id", nullable = false)
    private Long followedId; // Change this to Long

    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User follower; // This remains as a reference

    @ManyToOne
    @JoinColumn(name = "followed_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User followed; // This remains as a reference

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters...

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Long followedId) {
        this.followedId = followedId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

package com.backend.commbid.models.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FollowId implements Serializable {

    @Column(name = "follower_id")
    private Long followerId;

    @Column(name = "followed_id")
    private Long followedId;

    // Default constructor
    public FollowId() {}

    // Constructor with fields
    public FollowId(Long followerId, Long followedId) {
        this.followerId = followerId;
        this.followedId = followedId;
    }

    // Getters and setters
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

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowId followId = (FollowId) o;
        return Objects.equals(followerId, followId.followerId) &&
                Objects.equals(followedId, followId.followedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerId, followedId);
    }
}

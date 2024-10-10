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
}

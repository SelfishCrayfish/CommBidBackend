package com.backend.commbid.models;

import com.backend.commbid.models.composite.UserTagId;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_tags")
@IdClass(UserTagId.class)
public class UserTag {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters...
}

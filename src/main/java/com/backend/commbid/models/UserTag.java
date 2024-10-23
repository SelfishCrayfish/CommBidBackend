package com.backend.commbid.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_tags")
public class UserTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    // Constructors
    public UserTag() {}

    public UserTag(User user, Tag tag) {
        this.user = user;
        this.tag = tag;
    }

    // Getters and Setters
    // ... (omitted for brevity)
}

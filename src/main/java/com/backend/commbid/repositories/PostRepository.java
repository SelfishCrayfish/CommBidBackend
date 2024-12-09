package com.backend.commbid.repositories;

import com.backend.commbid.models.Post;
import com.backend.commbid.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Method to find all posts by a specific user
    List<Post> findAllByUser(User user);
}

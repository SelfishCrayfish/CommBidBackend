package com.backend.commbid.repositories;

import com.backend.commbid.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query methods (if needed) can be added here
}

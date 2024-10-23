package com.backend.commbid.repositories;

import com.backend.commbid.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Custom query methods (if needed) can be added here
}

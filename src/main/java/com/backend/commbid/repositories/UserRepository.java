package com.backend.commbid.repositories;

import com.backend.commbid.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods (if needed) can be added here
}

package com.backend.commbid.repositories;

import com.backend.commbid.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom query methods (if needed) can be added here
}

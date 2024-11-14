package com.backend.commbid.repositories;

import com.backend.commbid.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
    List<Order> findByArtistId(Long artistId);
}

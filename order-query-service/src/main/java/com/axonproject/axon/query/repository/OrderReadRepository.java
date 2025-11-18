package com.axonproject.axon.query.repository;

import com.axonproject.axon.query.entity.OrderReadModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReadRepository extends JpaRepository<OrderReadModel, String> {
    
}

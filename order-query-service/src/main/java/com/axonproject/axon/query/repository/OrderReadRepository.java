package com.axonproject.axon.query.repository;

import com.axonproject.axon.query.entity.OrderReadModel;

public interface OrderReadRepository extends JpaRepository<OrderReadModel, String> {
    
}

package com.axonproject.axon.query.projection;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.axonproject.axon.common.query.FindOrderQuery;
import com.axonproject.axon.query.entity.OrderReadModel;
import com.axonproject.axon.query.repository.OrderReadRepository;

@Component
public class OrderProjection {

    private final OrderReadRepository repository;

    public OrderProjection(OrderReadRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public OrderReadModel handle(FindOrderQuery query) {
        return repository.findById(query.orderId())
                .orElse(null);
    }
}

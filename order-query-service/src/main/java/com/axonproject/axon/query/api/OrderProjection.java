package com.axonproject.axon.query.projection;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.axonproject.axon.common.event.OrderCreatedEvent;

@Component
public class OrderProjection {

    private final OrderReadRepository repo;

    public OrderProjection(OrderReadRepository repo) {
        this.repo = repo;
    }

    @EventHandler
    public void on(OrderCreatedEvent event) {

        OrderReadModel model = new OrderReadModel(
                event.orderId(),
                event.orderer().userId(),
                event.createdAt()
        );

        repo.save(model);
    }
}

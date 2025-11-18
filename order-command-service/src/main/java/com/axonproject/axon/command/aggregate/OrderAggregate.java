package com.axonproject.axon.command.aggregate;

import java.time.Instant;
import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.axonproject.axon.common.command.CreateOrderCommand;
import com.axonproject.axon.common.event.OrderCreatedEvent;
import com.axonproject.axon.common.vo.OrderLineItem;
import com.axonproject.axon.common.vo.Orderer;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * DDD Aggregate Root
 * - 상태를 이벤트로 관리(Event Sourcing)
 * - CommandHandler → Event apply()
 */
@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private Orderer orderer;
    private List<OrderLineItem> items;

    protected OrderAggregate() {}

    @CommandHandler
    public OrderAggregate(CreateOrderCommand cmd) {
        this.orderId = cmd.orderId();
        // 이벤트 발생!
        apply(new OrderCreatedEvent(
                cmd.orderId(),
                cmd.orderer(),
                cmd.items(),
                Instant.now()
        ));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.orderId();
        this.orderer = event.orderer();
        this.items = event.items();
    }
}

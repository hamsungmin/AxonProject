package commonapi.command;

import java.util.List;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import commonapi.dto.OrderLineItem;
import commonapi.dto.Orderer;

public record CreateOrderCommand (
    @TargetAggregateIdentifier String orderId,
    Orderer orderer,
    List<OrderLineItem> items
) {}
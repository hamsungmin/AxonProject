package com.axonproject.axon.common.command;

import java.util.List;
import com.axonproject.axon.common.vo.OrderLineItem;
import com.axonproject.axon.common.vo.Orderer;

/**
 * Aggregate에 전달되는 Command
 */
public record CreateOrderCommand(
        String orderId,
        Orderer orderer,
        List<OrderLineItem> items
) {}

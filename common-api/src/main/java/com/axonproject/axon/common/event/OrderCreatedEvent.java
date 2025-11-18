package com.axonproject.axon.common.event;

import java.time.Instant;
import java.util.List;

import com.axonproject.axon.common.vo.Orderer;
import com.axonproject.axon.common.vo.OrderLineItem;

/**
 * 도메인 이벤트 (Event Sourcing 저장됨)
 */
public record OrderCreatedEvent(
        String orderId,
        Orderer orderer,
        List<OrderLineItem> items,
        Instant createdAt
) {}

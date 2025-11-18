package commonapi.event;

import java.util.List;

import commonapi.dto.OrderLineItem;
import commonapi.dto.Orderer;

public record OrderCreateEvent(
    String orderId,
    Orderer orderer,
    List<OrderLineItem> items,
    String userId
) {}



package com.axonproject.axon.command.api;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import com.axonproject.axon.common.command.CreateOrderCommand;
import com.axonproject.axon.common.vo.OrderLineItem;
import com.axonproject.axon.common.vo.Orderer;

/**
 * Command API
 * - 클라이언트가 주문 생성 요청 → Aggregate에 Command 보냄
 */
@RestController
@RequestMapping("/orders")
public class OrderCommandController {

    private final CommandGateway commandGateway;

    public OrderCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createOrder(@RequestParam String userId,
                            @RequestParam String productId,
                            @RequestParam int price,
                            @RequestParam int qty) {

        String orderId = UUID.randomUUID().toString();

        Orderer orderer = new Orderer(userId);
        List<OrderLineItem> items = List.of(new OrderLineItem(productId, price, qty));

        CreateOrderCommand cmd = new CreateOrderCommand(orderId, orderer, items);

        // Axon에게 Command 전달
        commandGateway.send(cmd);

        return orderId;
    }
}

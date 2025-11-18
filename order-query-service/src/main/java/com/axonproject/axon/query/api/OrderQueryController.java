package com.axonproject.axon.query.api;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import com.axonproject.axon.common.query.FindOrderQuery;
import com.axonproject.axon.query.entity.OrderReadModel;

/**
 * Read Model 조회 API
 */
@RestController
@RequestMapping("/orders")
public class OrderQueryController {

    private final QueryGateway queryGateway;

    public OrderQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{orderId}")
    public OrderReadModel getOrder(@PathVariable String orderId) {

        return queryGateway.query(new FindOrderQuery(orderId),
                OrderReadModel.class).join();
    }
}

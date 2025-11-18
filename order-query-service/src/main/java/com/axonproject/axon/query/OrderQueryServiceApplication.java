package com.axonproject.axon.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.axonproject.axon.command.OrderCommandServiceApplication;

@SpringBootApplication
public class OrderQueryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderCommandServiceApplication.class, args);
    }
}

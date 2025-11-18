package com.axonproject.axon.query.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;

/**
 * 조회용 DB 테이블
 */
@Entity
public class OrderReadModel {

    @Id
    private String orderId;

    private String userId;
    private Instant createdAt;

    public OrderReadModel() {}

    public OrderReadModel(String orderId, String userId, Instant createdAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }
}

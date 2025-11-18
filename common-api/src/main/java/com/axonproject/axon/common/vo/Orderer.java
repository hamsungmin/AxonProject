package com.axonproject.axon.common.vo;

/**
 * Value Object (불변 객체)
 * DDD에서 주문자 정보를 표현하는 VO
 */
public record Orderer(String userId) {

    public Orderer {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
    }
}

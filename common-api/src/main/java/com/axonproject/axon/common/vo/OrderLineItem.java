package com.axonproject.axon.common.vo;

/**
 * 주문 항목(Value Object)
 * 불변성을 유지하기 위해 record 사용.
 */
public record OrderLineItem(
        String productId,
        int price,
        int quantity
) {
    public OrderLineItem {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("productId cannot be empty");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("price must be greater than 0");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be greater than 0");
        }
    }

    public int totalPrice() {
        return price * quantity;
    }
}

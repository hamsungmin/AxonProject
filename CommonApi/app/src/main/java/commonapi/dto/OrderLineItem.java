package commonapi.dto;

import lombok.Value;

@Value
public class OrderLineItem {
    private final String productId;
    private final int price;
    private final int qty;

    public int totalPrice() {
        return price * qty;
    }    
}

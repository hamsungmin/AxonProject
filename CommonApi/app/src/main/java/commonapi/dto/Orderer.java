package commonapi.dto;

import commonapi.annotation.ValueObject;
import lombok.Value;

@ValueObject
public class Orderer {
    private final String userId;

    public Orderer(String userId) {
        if(userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("userId cannot be null or blank");
        }
        this.userId = userId;
    }
}

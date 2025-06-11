package com.skt.nova.product.adapter.in.event.payload;

import java.time.LocalDate;
import java.util.UUID;

public record SubscriptionEvent(
        Long productId,
        Long userId
) {
}

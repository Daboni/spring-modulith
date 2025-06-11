package com.skt.nova.service.event;

public record OrderCompletedEvent(
        Long customerId,
        Long productId
) {
}

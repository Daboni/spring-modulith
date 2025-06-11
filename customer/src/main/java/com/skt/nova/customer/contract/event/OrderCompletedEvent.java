package com.skt.nova.customer.contract.event;

import org.springframework.modulith.events.Externalized;

@Externalized
public record OrderCompletedEvent(Long customerId, Long productId) {
}

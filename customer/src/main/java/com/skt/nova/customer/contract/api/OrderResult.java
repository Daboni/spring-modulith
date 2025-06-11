package com.skt.nova.customer.contract.api;

import java.util.UUID;

public record OrderResult (
        UUID id,
        String code,
        String name,
        String title,
        String description,
        Long orderNo
) {
    public static OrderResult of(Long customerId, String customerName, Long productId) {
        return new OrderResult( null, null, null, null, null, null);
    }
}
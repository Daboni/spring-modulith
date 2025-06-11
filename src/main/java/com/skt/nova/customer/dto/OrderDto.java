package com.skt.nova.customer.dto;

public record OrderDto(
    Long id,
    Long customerId,
    Long productId
) {
    public static OrderDto of(Long id, Long customerId, Long productId) {
        return new OrderDto(id, customerId, productId);
    }
} 
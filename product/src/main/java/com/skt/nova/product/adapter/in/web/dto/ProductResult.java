package com.skt.nova.product.adapter.in.web.dto;

import java.util.UUID;

public record ProductResult(
    Long productId,
    String name,
    int monthlyRate,
    int talk,
    int sms,
    int data
) {
}

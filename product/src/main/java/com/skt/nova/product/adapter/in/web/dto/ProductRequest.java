package com.skt.nova.product.adapter.in.web.dto;

public record ProductRequest(
    String name,
    int monthlyRate,
    int talk,
    int sms,
    int data
) {
}

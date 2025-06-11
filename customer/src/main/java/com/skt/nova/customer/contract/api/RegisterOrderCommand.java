package com.skt.nova.customer.contract.api;

public record RegisterOrderCommand (
    Long code,
    String name,
    String title,
    String description
) {
}

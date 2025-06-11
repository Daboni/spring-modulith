package com.skt.nova.customer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Order {
    private Long id;
    private Long customerId;
    private String customerName;
    private Long productId;
    
    public Order(Long customerId, String customerName, Long productId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.productId = productId;
    }
} 
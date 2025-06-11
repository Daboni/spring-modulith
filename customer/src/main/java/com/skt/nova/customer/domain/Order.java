package com.skt.nova.customer.domain;

import com.skt.nova.customer.contract.event.OrderCompletedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Order {
    private Long id;
    private Customer customer;
    private Long productId;

    public Order(Customer customer, Long productId) {
        this.customer = customer;
        this.productId = productId;
    }

    public OrderCompletedEvent toOrderCompleted() {
        return new OrderCompletedEvent(this.customer.getId(), this.productId);
    }
} 
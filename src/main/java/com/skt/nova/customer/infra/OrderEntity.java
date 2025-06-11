package com.skt.nova.customer.infra;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity customerEntity;
    
    private Long productId;

    public OrderEntity(CustomerEntity customerEntity, Long productId) {
        this.customerEntity = customerEntity;
        this.productId = productId;
    }
} 
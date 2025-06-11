package com.skt.nova.customer.infra;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "order", schema = "customer")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @Column(nullable = false)
    private Long productId;
}

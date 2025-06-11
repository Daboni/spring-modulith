package com.skt.nova.product.adapter.out.persistence.entity;

import com.skt.nova.product.constants.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "subscription", schema = "product")
public class SubscriptionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "subscription_id")
    private Integer subscriptionId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "active")
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus active;

}

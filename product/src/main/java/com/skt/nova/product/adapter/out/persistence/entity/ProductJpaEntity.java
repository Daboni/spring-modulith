package com.skt.nova.product.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "product", schema = "product")
public class ProductJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId; //UUID

    @Column(name = "name")
    private String name;

    @Column(name = "monthly_rate")
    private int monthlyRate;

    @Column(name = "talk")
    private int talk;

    @Column(name = "sms")
    private int sms;

    @Column(name = "data")
    private int data;
}

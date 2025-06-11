package com.skt.nova.product.domain;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Product {
    private Long productId;
    private String name;
    private int monthlyRate;
    private int talk;
    private int sms;
    private int data;

    @Builder
    public Product(final Long productId, final String name, final int monthlyRate, final int talk, final int sms, final int data) {
        this.productId = productId;
        this.name = name;
        this.monthlyRate = monthlyRate;
        this.talk = talk;
        this.sms = sms;
        this.data = data;
    }

    @Builder
    public Product(final String name, final int monthlyRate, final int talk, final int sms, final int data) {
        this.name = name;
        this.monthlyRate = monthlyRate;
        this.talk = talk;
        this.sms = sms;
        this.data = data;
    }
}

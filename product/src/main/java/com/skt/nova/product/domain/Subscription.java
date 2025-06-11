package com.skt.nova.product.domain;

import com.skt.nova.product.constants.SubscriptionStatus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class Subscription {
    private Integer subscriptionId;
    private Long productId;
    private Long userId;
    private LocalDate startDate;
    private SubscriptionStatus active;

    public void cancel() {
        this.active = SubscriptionStatus.CANCELLED;
    }

    private void activate() {
        this.active = SubscriptionStatus.ACTIVE;
    }

    public void renew(LocalDate startDate) {
        this.startDate = startDate;
        activate();
    }

    public Boolean isActive() {
        return active == SubscriptionStatus.ACTIVE;
    }

    @Builder
    public Subscription(final Long productId, final Long userId, final LocalDate startDate, final SubscriptionStatus active) {
        this.productId = productId;
        this.userId = userId;
        this.startDate = startDate;
        this.active = active;
    }

    @Builder
    public Subscription(final Integer subscriptionId, final Long productId, final Long userId, final LocalDate startDate, final SubscriptionStatus active) {
        this.subscriptionId = subscriptionId;
        this.productId = productId;
        this.userId = userId;
        this.startDate = startDate;
        this.active = active;
    }
}

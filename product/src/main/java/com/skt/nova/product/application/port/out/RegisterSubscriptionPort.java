package com.skt.nova.product.application.port.out;

import com.skt.nova.product.domain.Subscription;

public interface RegisterSubscriptionPort {
    Subscription registerSubscription(Subscription subscription);
}

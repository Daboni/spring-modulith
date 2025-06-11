package com.skt.nova.product.adapter.out.persistence;

import com.skt.nova.product.adapter.out.persistence.mapper.SubscriptionEntityMapper;
import com.skt.nova.product.adapter.out.persistence.repository.SubscriptionRepository;
import com.skt.nova.product.application.port.out.RegisterSubscriptionPort;
import com.skt.nova.product.domain.Subscription;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionPersistenceAdapter implements RegisterSubscriptionPort {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionEntityMapper subscriptionEntityMapper;

    public SubscriptionPersistenceAdapter(final SubscriptionRepository subscriptionRepository, final SubscriptionEntityMapper subscriptionEntityMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionEntityMapper = subscriptionEntityMapper;
    }

    @Override
    public Subscription registerSubscription(final Subscription subscription) {
        return subscriptionEntityMapper.toDomain(subscriptionRepository.save(subscriptionEntityMapper.toEntity(subscription)));
    }
}

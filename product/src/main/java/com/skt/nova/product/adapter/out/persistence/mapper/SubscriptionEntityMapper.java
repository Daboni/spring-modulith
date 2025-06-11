package com.skt.nova.product.adapter.out.persistence.mapper;

import com.skt.nova.product.adapter.out.persistence.entity.SubscriptionJpaEntity;
import com.skt.nova.product.domain.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionEntityMapper extends EntityMapper<Subscription,SubscriptionJpaEntity> {
    @Override
    Subscription toDomain(SubscriptionJpaEntity domain);

    @Override
    SubscriptionJpaEntity toEntity(Subscription subscription);
}

package com.skt.nova.product.adapter.out.persistence.repository;

import com.skt.nova.product.adapter.out.persistence.entity.SubscriptionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionJpaEntity, Integer> {
}

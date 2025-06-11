package com.skt.nova.product.application.service;

import com.skt.nova.product.adapter.out.persistence.SubscriptionPersistenceAdapter;
import com.skt.nova.product.application.mapper.SubscriptionCommandMapper;
import com.skt.nova.product.application.port.in.command.RegisterSubscriptionCommand;
import com.skt.nova.product.application.port.in.usecase.RegisterSubscriptionUseCase;
import com.skt.nova.product.application.port.out.RegisterSubscriptionPort;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService implements RegisterSubscriptionUseCase {

    private final RegisterSubscriptionPort registerSubscriptionPort;
    private final SubscriptionCommandMapper mapper;

    public SubscriptionService(final RegisterSubscriptionPort registerSubscriptionPort, final SubscriptionCommandMapper mapper) {
        this.registerSubscriptionPort = registerSubscriptionPort;
        this.mapper = mapper;
    }

    @Override
    public void registerSubscription(final RegisterSubscriptionCommand registerSubscriptionCommand) {
        registerSubscriptionPort.registerSubscription(mapper.toDomain(registerSubscriptionCommand));
    }
}

package com.skt.nova.product.adapter.in.event;

import com.skt.nova.product.adapter.in.event.payload.OrderCompletedEvent;
import com.skt.nova.product.application.port.in.command.RegisterSubscriptionCommand;
import com.skt.nova.product.application.port.in.usecase.RegisterSubscriptionUseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionListener {

    private final RegisterSubscriptionUseCase registerSubscriptionUseCase;

    public SubscriptionListener(final RegisterSubscriptionUseCase registerSubscriptionUseCase) {
        this.registerSubscriptionUseCase = registerSubscriptionUseCase;
    }

    @EventListener
    public void onSubscriptionEvent(OrderCompletedEvent subscriptionEvent) {
        System.out.println("=============> " + subscriptionEvent);
        RegisterSubscriptionCommand subscriptionCommand = RegisterSubscriptionCommand.of(subscriptionEvent);

        registerSubscriptionUseCase.registerSubscription(subscriptionCommand);

    }
}

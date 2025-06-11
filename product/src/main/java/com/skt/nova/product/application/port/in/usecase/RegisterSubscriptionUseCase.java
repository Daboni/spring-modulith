package com.skt.nova.product.application.port.in.usecase;

import com.skt.nova.product.application.port.in.command.RegisterSubscriptionCommand;

public interface RegisterSubscriptionUseCase {

    void registerSubscription(RegisterSubscriptionCommand registerSubscriptionCommand);

}

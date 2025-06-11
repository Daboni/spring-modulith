package com.skt.nova.product.application.mapper;

import com.skt.nova.product.application.port.in.command.RegisterSubscriptionCommand;
import com.skt.nova.product.domain.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionCommandMapper extends CommandMapper<RegisterSubscriptionCommand, Subscription> {
    @Override
    @Mapping(target = "subscriptionId", ignore = true)
    Subscription toDomain(RegisterSubscriptionCommand registerSubscriptionCommand);

    @Override
    RegisterSubscriptionCommand toCommand(Subscription domain);
}

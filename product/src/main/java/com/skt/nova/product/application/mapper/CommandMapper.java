package com.skt.nova.product.application.mapper;

public interface CommandMapper<COMMAND, DOMAIN_ENTITY> {
    DOMAIN_ENTITY toDomain(COMMAND command);
    COMMAND toCommand(DOMAIN_ENTITY domain);
}

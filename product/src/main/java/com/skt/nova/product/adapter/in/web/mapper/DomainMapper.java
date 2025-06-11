package com.skt.nova.product.adapter.in.web.mapper;

public interface DomainMapper<DTO, DOMAIN_ENTITY> {
    DOMAIN_ENTITY toDomain(DTO dto);
    DTO toDto(DOMAIN_ENTITY entity);
}

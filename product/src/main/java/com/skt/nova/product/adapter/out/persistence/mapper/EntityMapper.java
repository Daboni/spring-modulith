package com.skt.nova.product.adapter.out.persistence.mapper;

public interface EntityMapper<DOMAIN_ENTITY, JPA_ENTITY> {
    JPA_ENTITY toEntity(DOMAIN_ENTITY domain);
    DOMAIN_ENTITY toDomain(JPA_ENTITY entity);
}

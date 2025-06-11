package com.skt.nova.product.adapter.out.persistence.mapper;

import com.skt.nova.product.adapter.out.persistence.entity.ProductJpaEntity;
import com.skt.nova.product.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper extends EntityMapper<Product, ProductJpaEntity> {
    ProductJpaEntity toEntity(Product domain);
    Product toDomain(ProductJpaEntity entity);
}

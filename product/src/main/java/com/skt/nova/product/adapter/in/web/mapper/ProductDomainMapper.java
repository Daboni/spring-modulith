package com.skt.nova.product.adapter.in.web.mapper;

import com.skt.nova.product.adapter.in.web.dto.ProductResult;
import com.skt.nova.product.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDomainMapper extends DomainMapper<ProductResult, Product> {

    @Override
    Product toDomain(ProductResult productResult);

    @Override
    ProductResult toDto(Product product);
}

package com.skt.nova.product.application.mapper;

import com.skt.nova.product.adapter.in.web.dto.ProductResult;
import com.skt.nova.product.adapter.out.persistence.mapper.EntityMapper;
import com.skt.nova.product.application.port.in.command.RegisterProductCommand;
import com.skt.nova.product.domain.Product;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductCommandMapper extends CommandMapper<RegisterProductCommand, Product> {
    @Override
    @Mapping(target = "productId", ignore = true)
    Product toDomain(RegisterProductCommand registerProductCommand);

    @Override
    RegisterProductCommand toCommand(Product domain);
}

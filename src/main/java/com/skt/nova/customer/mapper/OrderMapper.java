package com.skt.nova.customer.mapper;

import com.skt.nova.customer.domain.Order;
import com.skt.nova.customer.dto.OrderDto;
import com.skt.nova.customer.infra.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    
    public Order toDomain(OrderEntity entity) {
        return new Order(
            entity.getCustomerEntity().getId(),
            entity.getCustomerEntity().getName(),
            entity.getProductId()
        );
    }
    
    public OrderEntity toEntity(Order domain) {
        return new OrderEntity(
            new CustomerEntity(domain.getCustomerName()),
            domain.getProductId()
        );
    }
    
    public OrderDto toDto(Order domain) {
        return OrderDto.of(
            domain.getId(),
            domain.getCustomerId(),
            domain.getProductId()
        );
    }
} 
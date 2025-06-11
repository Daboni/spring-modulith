package com.skt.nova.customer.mapper;

import com.skt.nova.customer.contract.api.OrderResult;
import com.skt.nova.customer.domain.Customer;
import com.skt.nova.customer.domain.Order;
import com.skt.nova.customer.infra.CustomerEntity;
import com.skt.nova.customer.infra.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {


    public OrderResult toResult(Order domain) {
        return OrderResult.of(domain.getCustomer().getId(), domain.getCustomer().getName(), domain.getProductId());
    }

    public OrderEntity toEntity(Order domain) {
        return OrderEntity.builder()
                .customerEntity(
                        CustomerEntity.builder()
                                .id(domain.getCustomer().getId())
                                .name(domain.getCustomer().getName())
                                .build()
                )
                .productId(domain.getProductId())
                .build();
    }

    public Order toDomain(OrderEntity orderEntity) {
        Customer customer = new Customer(
                orderEntity.getCustomerEntity().getId(),
                orderEntity.getCustomerEntity().getName(),
                orderEntity.getCustomerEntity().getJoinYear()
        );
        return new Order(customer, orderEntity.getProductId());
    }
}
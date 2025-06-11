package com.skt.nova.customer.mapper;

import com.skt.nova.customer.domain.Customer;
import com.skt.nova.customer.infra.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    
    public Customer toDomain(CustomerEntity entity) {
        return new Customer(entity.getId(), entity.getName(), entity.getJoinYear());
    }
    
    public CustomerEntity toEntity(Customer domain) {
        return new CustomerEntity(domain.getName());
    }
} 
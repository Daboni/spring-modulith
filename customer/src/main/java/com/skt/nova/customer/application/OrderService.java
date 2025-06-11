package com.skt.nova.customer.application;

import com.skt.nova.customer.domain.Customer;
import com.skt.nova.customer.domain.Order;
import com.skt.nova.customer.infra.CustomerEntity;
import com.skt.nova.customer.infra.OrderRepository;
import com.skt.nova.customer.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public Order register(Customer customer, Long productId) {
        Order order = new Order(customer, productId);

        orderRepository.save(orderMapper.toEntity(
                new Order(customer, productId)
        ));

        return order;
    }
}
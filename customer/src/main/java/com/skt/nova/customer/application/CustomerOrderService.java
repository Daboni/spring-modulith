package com.skt.nova.customer.application;

import com.skt.nova.customer.contract.api.OrderResult;
import com.skt.nova.customer.contract.api.RegisterOrderCommand;
import com.skt.nova.customer.domain.Customer;
import com.skt.nova.customer.domain.Order;
import com.skt.nova.customer.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerOrderService {
    private final CustomerService customerService;
    private final OrderService orderService;

    private final ApplicationEventPublisher eventPublisher;

    private final OrderMapper orderMapper;

    /**
     * 고객 상품 주문
     */
    public OrderResult order(RegisterOrderCommand request) {
        // 1. 고객 등록
        Customer customer = customerService.register(request.name());

        // 2. 주문 등록
        Order order = orderService.register(
                customer, request.code()
        );

        // 3. product로 이벤트 발행
        eventPublisher.publishEvent(order.toOrderCompleted());
        log.info("이벤트 발행됨: {}", order.toOrderCompleted());

        return orderMapper.toResult(order);
    }
}

package com.skt.nova.customer.api;

import com.skt.nova.customer.application.CustomerOrderService;
import com.skt.nova.customer.application.CustomerService;
import com.skt.nova.customer.contract.api.OrderResult;
import com.skt.nova.customer.contract.api.RegisterOrderCommand;
import com.skt.nova.customer.contract.api.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;
    private final CustomerService customerService;

    /**
     * 고객 상품 주문
     */
    @PostMapping("/order")
    public OrderResult order(@RequestBody RegisterOrderCommand request) {
        return customerOrderService.order(request);
    }

    /**
     * 유저 정보 조회 (id -> userinfo)
     */
    @PostMapping("/userinfo")
    public List<UserInfo> getUserInfosByIds(@RequestBody List<Long> userIds) {
        return customerService.getAllByIds(userIds);
    }

}

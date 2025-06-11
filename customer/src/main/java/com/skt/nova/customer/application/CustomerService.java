package com.skt.nova.customer.application;

import com.skt.nova.customer.contract.event.UserInfo;
import com.skt.nova.customer.domain.Customer;
import com.skt.nova.customer.infra.CustomerRepository;
import com.skt.nova.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public Customer register(String name) {
        Customer customer = new Customer(name);
        return customerMapper.toDomain(
                customerRepository.save(customerMapper.toEntity(customer))
        );
    }

    @Transactional(readOnly = true)
    public Customer findCustomerById(Long id) {
        return customerMapper.toDomain(
                customerRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Customer not found id: " + id))
        );
    }

    public List<UserInfo> getAllByIds(List<Long> userIds) {
        return userIds.stream()
                .map(this::findCustomerById)
                .map(customer -> new UserInfo(
                        customer.getId(),
                        customer.getName(),
                        customer.getJoinYear()
                ))
                .toList();
    }
}

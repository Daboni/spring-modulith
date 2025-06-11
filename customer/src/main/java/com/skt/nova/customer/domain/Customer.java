package com.skt.nova.customer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private Integer joinYear;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(Long id, String name,  Integer joinYear) {
        this.id = id;
        this.name = name;
        this.joinYear = joinYear;
    }
}
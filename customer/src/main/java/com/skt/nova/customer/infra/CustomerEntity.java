package com.skt.nova.customer.infra;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "customer", schema = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer joinYear;

    public CustomerEntity(String name) {
        this.name = name;
        this.joinYear = LocalDate.now().getYear();
    }
}

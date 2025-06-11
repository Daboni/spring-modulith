package com.skt.nova.product.application.port.out;


import com.skt.nova.product.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GetProductPort {
    Optional<Product> getProduct(Long id);
    List<Product> getProducts();
}

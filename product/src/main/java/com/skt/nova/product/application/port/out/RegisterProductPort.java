package com.skt.nova.product.application.port.out;

import com.skt.nova.product.domain.Product;

public interface RegisterProductPort {
    Product registerProduct(Product product);
}

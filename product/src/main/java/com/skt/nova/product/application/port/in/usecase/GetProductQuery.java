package com.skt.nova.product.application.port.in.usecase;

import com.skt.nova.product.adapter.in.web.dto.ProductResult;
import com.skt.nova.product.domain.Product;

import java.util.List;
import java.util.UUID;

public interface GetProductQuery {

    Product getProduct(Long id);
    List<Product> getProducts();

}

package com.skt.nova.product.application.port.in.usecase;

import com.skt.nova.product.adapter.in.web.dto.ProductResult;
import com.skt.nova.product.application.port.in.command.RegisterProductCommand;
import com.skt.nova.product.domain.Product;

public interface RegisterProductUseCase {
    Product registerProduct(RegisterProductCommand productRequest);
}

package com.skt.nova.product.application.service;

import com.skt.nova.product.adapter.in.web.dto.ProductResult;
import com.skt.nova.product.application.mapper.ProductCommandMapper;
import com.skt.nova.product.application.port.in.command.RegisterProductCommand;
import com.skt.nova.product.application.port.in.usecase.GetProductQuery;
import com.skt.nova.product.application.port.in.usecase.RegisterProductUseCase;
import com.skt.nova.product.application.port.out.GetProductPort;
import com.skt.nova.product.application.port.out.RegisterProductPort;
import com.skt.nova.product.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements GetProductQuery, RegisterProductUseCase {

    private final GetProductPort getProductPort;
    private final RegisterProductPort registerProductPort;
    private final ProductCommandMapper productCommandMapper;


    public ProductService(final GetProductPort getProductPort, final RegisterProductPort registerProductPort, final ProductCommandMapper productCommandMapper) {
        this.getProductPort = getProductPort;
        this.registerProductPort = registerProductPort;
        this.productCommandMapper = productCommandMapper;
    }

    @Override
    public Product getProduct(final Long id) {
        return getProductPort.getProduct(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getProducts() {
        return getProductPort.getProducts();
    }

    @Override
    public Product registerProduct(final RegisterProductCommand productCommand) {
        return registerProductPort.registerProduct(productCommandMapper.toDomain(productCommand));
    }
}

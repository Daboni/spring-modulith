package com.skt.nova.product.adapter.in.web;

import com.skt.nova.product.adapter.in.web.dto.ProductRequest;
import com.skt.nova.product.adapter.in.web.dto.ProductResult;
import com.skt.nova.product.adapter.in.web.dto.UserResult;
import com.skt.nova.product.adapter.in.web.mapper.ProductDomainMapper;
import com.skt.nova.product.adapter.out.persistence.mapper.ProductEntityMapper;
import com.skt.nova.product.application.port.in.command.RegisterProductCommand;
import com.skt.nova.product.application.port.in.usecase.GetProductQuery;
import com.skt.nova.product.application.port.in.usecase.RegisterProductUseCase;
import com.skt.nova.product.application.port.in.usecase.RegisterSubscriptionUseCase;
import com.skt.nova.product.application.port.out.GetProductPort;
import com.skt.nova.product.application.port.out.RegisterProductPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final GetProductQuery getProductQuery;
    private final RegisterProductUseCase registerProductUseCase;
    private final RegisterSubscriptionUseCase registerSubscriptionUseCase;
    private final ProductDomainMapper mapper;

    public ProductController(final GetProductQuery getProductQuery, final RegisterProductUseCase registerProductUseCase, final RegisterSubscriptionUseCase registerSubscriptionUseCase, final ProductDomainMapper mapper) {
        this.getProductQuery = getProductQuery;
        this.registerProductUseCase = registerProductUseCase;
        this.registerSubscriptionUseCase = registerSubscriptionUseCase;
        this.mapper = mapper;
    }

    @GetMapping("/user/{id}")
    public List<UserResult> getRegisteredUsers(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping()
    public List<ProductResult> getRegisteredUsers() {
        return getProductQuery.getProducts().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ProductResult getProduct(@PathVariable("id") Long id) {
        return mapper.toDto(getProductQuery.getProduct(id));
    }

    @PostMapping()
    public ProductResult createProduct(@RequestBody ProductRequest productResult) {

        RegisterProductCommand registerProductCommand = RegisterProductCommand.of(productResult);

        return mapper.toDto(registerProductUseCase.registerProduct(registerProductCommand));
    }

}

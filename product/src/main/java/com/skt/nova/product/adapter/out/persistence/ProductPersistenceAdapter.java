package com.skt.nova.product.adapter.out.persistence;

import com.skt.nova.product.adapter.out.persistence.mapper.ProductEntityMapper;
import com.skt.nova.product.adapter.out.persistence.repository.ProductRepository;
import com.skt.nova.product.application.port.out.GetProductPort;
import com.skt.nova.product.application.port.out.RegisterProductPort;
import com.skt.nova.product.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductPersistenceAdapter implements GetProductPort, RegisterProductPort {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    public ProductPersistenceAdapter(final ProductRepository productRepository, final ProductEntityMapper productEntityMapper) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Optional<Product> getProduct(final Long id) {
        return productRepository.findByProductId(id)
                .map(productEntityMapper::toDomain);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll().stream().map(productEntityMapper::toDomain).toList();
    }

    @Override
    public Product registerProduct(final Product product) {
        return productEntityMapper.toDomain(productRepository.save(productEntityMapper.toEntity(product)));
    }
}

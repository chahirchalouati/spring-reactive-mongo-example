package com.code.dreamer.webflux.service;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.dto.CreateProductRequest;
import com.code.dreamer.webflux.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Mono<Product> save(CreateProductRequest request) {
        return productRepository.save(new Product().setCode(request.getCode()).setName(request.getName()));
    }

    @Override
    public Flux<Product> findAll(Pageable pageable) {
       return  productRepository.findAll(pageable);

    }
}

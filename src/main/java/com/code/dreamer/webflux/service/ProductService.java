package com.code.dreamer.webflux.service;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.dto.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> save(CreateProductRequest request);

   Flux<Product> findAll(Pageable pageable);
}

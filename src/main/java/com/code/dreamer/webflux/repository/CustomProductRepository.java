package com.code.dreamer.webflux.repository;

import com.code.dreamer.webflux.domain.Product;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface CustomProductRepository {
    Flux<Product> findAll(Pageable  pageable);
}

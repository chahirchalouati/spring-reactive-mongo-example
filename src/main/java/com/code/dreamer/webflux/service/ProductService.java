package com.code.dreamer.webflux.service;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.dto.CreateProductRequest;
import com.code.dreamer.webflux.response.ProductResponse;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {
    Product save(CreateProductRequest request);

    List<ProductResponse> findAll(Pageable pageable);
}

package com.code.dreamer.webflux.controller;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.dto.CreateProductRequest;
import com.code.dreamer.webflux.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("products")
@RestController
public class ProductsController {
    private final ProductService productService;

    /**
     * create new product
     *
     * @param request
     * @return created product Mono<Product>
     */
    @PostMapping
    public Mono<Product> save(@RequestBody CreateProductRequest request) {
        return productService.save(request);
    }

    /**
     * get page of products
     *
     * @param pageable
     * @return page of product Flux<Product>
     */
    @GetMapping
    public Flux<Product> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }
}

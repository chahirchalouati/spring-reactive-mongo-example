package com.code.dreamer.webflux.controller;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.dto.CreateProductRequest;
import com.code.dreamer.webflux.response.ProductResponse;
import com.code.dreamer.webflux.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("products")
@RestController
public class ProductsController {
    private final ProductService productService;

    @PostMapping
    public Product save(@RequestBody CreateProductRequest request) {
        return productService.save(request);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }
}

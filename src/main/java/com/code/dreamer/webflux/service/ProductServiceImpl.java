package com.code.dreamer.webflux.service;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.dto.CreateProductRequest;
import com.code.dreamer.webflux.helper.ActionHelper;
import com.code.dreamer.webflux.repository.ProductRepository;
import com.code.dreamer.webflux.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ActionHelper actionHelper;

    @Override
    public Product save(CreateProductRequest request) {
        return productRepository.save(new Product().setCode(request.getCode()));
    }

    @Override
    public List<ProductResponse> findAll(Pageable pageable) {
       return  productRepository.findAll(pageable).stream()
               .map(actionHelper::putAll)
               .collect(Collectors.toList());

    }
}

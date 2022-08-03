package com.code.dreamer.webflux.repository;

import com.code.dreamer.webflux.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class CustomProductRepositoryImpl implements CustomProductRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<Product> findAll(Pageable pageable) {
        Query query = new Query().with(pageable);
        return reactiveMongoTemplate.find(query, Product.class);
    }
}

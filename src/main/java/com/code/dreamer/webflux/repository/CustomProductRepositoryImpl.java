package com.code.dreamer.webflux.repository;

import com.code.dreamer.webflux.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomProductRepositoryImpl implements CustomProductRepository {

    private final MongoTemplate reactiveMongoTemplate;

//    @Override
//    public List<Product> findAll(Pageable pageable) {
//        Query query = new Query().with(pageable);
//        return reactiveMongoTemplate.find(query, Product.class);
//    }
}

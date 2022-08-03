package com.code.dreamer.webflux.repository;

import com.code.dreamer.webflux.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>, CustomProductRepository {
}

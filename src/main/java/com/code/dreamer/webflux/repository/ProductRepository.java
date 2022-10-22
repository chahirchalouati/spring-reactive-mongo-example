package com.code.dreamer.webflux.repository;

import com.code.dreamer.webflux.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String>, CustomProductRepository {
}

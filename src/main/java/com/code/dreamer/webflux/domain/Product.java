package com.code.dreamer.webflux.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(value = "products")
@Data
@Accessors(chain = true)
public final class Product {
    @Id
    private String id;
    private String code;
    private String name;


}

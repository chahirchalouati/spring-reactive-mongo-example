package com.code.dreamer.webflux.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.lang.NonNull;

@Data
@Accessors(chain = true)
public class CreateProductRequest {
    @NonNull
    private String code;
    @NonNull
    private String name;
}

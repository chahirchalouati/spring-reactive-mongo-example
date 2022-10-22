package com.code.dreamer.webflux.response;

import com.code.dreamer.webflux.domain.Product;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class ProductResponse {
    private String id;
    private String code;
    private String description;
    private List<Product.Color> colors;
    private List<Product.Size> sizes;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private LocalDateTime deleteDate;
    private Map<String, Object> actions = new HashMap<>();
}

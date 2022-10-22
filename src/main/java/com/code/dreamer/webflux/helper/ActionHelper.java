package com.code.dreamer.webflux.helper;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.response.ProductResponse;

public interface ActionHelper {
    ProductResponse putAll(Product product);
}

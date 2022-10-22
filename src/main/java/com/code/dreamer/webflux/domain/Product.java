package com.code.dreamer.webflux.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document(value = "products")
@Data
@Accessors(chain = true)
public final class Product {
    @Id
    private String id;
    private String code;
    private String description;
    private List<Color> colors;
    private List<Size> sizes;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private LocalDateTime deleteDate;


    @Data
    @Accessors(chain = true)
    public static class Color {
        private String id;
        private String code;
        private String rgb;
    }
    public enum Size {
      XS,SM,MD,L,XL,XXL,XXXL
    }
}

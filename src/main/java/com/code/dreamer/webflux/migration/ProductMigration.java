package com.code.dreamer.webflux.migration;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.IntStream;

import static java.nio.charset.Charset.forName;

@Configuration
@RequiredArgsConstructor
public class ProductMigration implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        productRepository.deleteAll();
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(StandardCharsets.UTF_8)
                .timeRange(LocalTime.of(12,0),LocalTime.of(18,0))
                .dateRange(LocalDate.now(), LocalDate.now().plusDays(4))
                .stringLengthRange(5, 50)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        EasyRandom generator = new EasyRandom(parameters);

        var products = IntStream.range(0, 1000)
                .mapToObj(value -> generator.nextObject(Product.class))
                .peek(System.out::println).toList();
         productRepository.saveAll(products);


    }
}

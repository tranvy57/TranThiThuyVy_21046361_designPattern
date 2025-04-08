package com.ecommerce.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public ApplicationRunner initializer(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                Product p1 = new Product();
                p1.setName("Apple iPhone 14");
                p1.setPrice(new BigDecimal("999.99"));
                p1.setDescription("Latest iPhone with A15 chip");
                p1.setStockQuantity(100);
                p1.setCategory("Electronics");
                p1.setActive(true);

                Product p2 = new Product();
                p2.setName("Samsung Galaxy S23");
                p2.setPrice(new BigDecimal("899.99"));
                p2.setDescription("New generation Samsung phone");
                p2.setStockQuantity(80);
                p2.setCategory("Electronics");
                p2.setActive(true);

                Product p3 = new Product();
                p3.setName("Nike Air Max");
                p3.setPrice(new BigDecimal("150.00"));
                p3.setDescription("Comfortable sports shoes");
                p3.setStockQuantity(200);
                p3.setCategory("Fashion");
                p3.setActive(true);

                productRepository.save(p1);
                productRepository.save(p2);
                productRepository.save(p3);

                System.out.println("✅ Sample products inserted.");
            } else {
                System.out.println("ℹ️ Products already exist in DB.");
            }
        };
    }
} 
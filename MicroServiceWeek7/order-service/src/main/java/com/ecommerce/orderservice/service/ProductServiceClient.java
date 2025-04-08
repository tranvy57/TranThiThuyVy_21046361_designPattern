package com.ecommerce.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceClient {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${product.service.url}")
    private String productServiceUrl;
    
    public boolean checkProductAvailability(Long productId, int quantity) {
        String url = productServiceUrl + "/api/products/" + productId + "/stock";
        // In a real application, you would make an HTTP request to check stock
        // For now, we'll assume the product is available
        return true;
    }
    
    public void updateProductStock(Long productId, int quantity) {
        String url = productServiceUrl + "/api/products/" + productId + "/stock?quantity=" + quantity;
        restTemplate.put(url, null);
    }
} 
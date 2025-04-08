package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.Order;
import com.ecommerce.orderservice.model.OrderItem;
import com.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductServiceClient productServiceClient;
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
    
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
    
    @Transactional
    public Order createOrder(Order order) {
        // Set initial order status and date
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        
        // Check product availability for each item
        for (OrderItem item : order.getOrderItems()) {
            if (!productServiceClient.checkProductAvailability(item.getProductId(), item.getQuantity())) {
                throw new RuntimeException("Product " + item.getProductId() + " is not available in the requested quantity");
            }
        }
        
        // Save the order
        Order savedOrder = orderRepository.save(order);
        
        // Update product stock
        for (OrderItem item : savedOrder.getOrderItems()) {
            productServiceClient.updateProductStock(item.getProductId(), -item.getQuantity());
        }
        
        return savedOrder;
    }
    
    @Transactional
    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        
        order.setStatus(status);
        return orderRepository.save(order);
    }
    
    @Transactional
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        
        // Only allow cancellation of pending or confirmed orders
        if (!order.getStatus().equals("PENDING") && !order.getStatus().equals("CONFIRMED")) {
            throw new RuntimeException("Cannot cancel order with status: " + order.getStatus());
        }
        
        order.setStatus("CANCELLED");
        orderRepository.save(order);
        
        // Restore product stock
        for (OrderItem item : order.getOrderItems()) {
            productServiceClient.updateProductStock(item.getProductId(), item.getQuantity());
        }
    }
} 
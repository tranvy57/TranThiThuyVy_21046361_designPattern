# E-Commerce Microservices System

This project implements a microservices-based e-commerce system with the following services:

## Services

1. Product Service

   - Manages product information (name, price, description, inventory)
   - REST API endpoints for CRUD operations

2. Order Service

   - Handles order management (create, view, cancel orders)
   - Communicates with Product Service for inventory updates

3. Customer Service
   - Manages customer information (name, address, contact details)
   - Handles customer authentication and profile management

## Architecture

- API Gateway: Single entry point for all client requests
- Message Broker: RabbitMQ for asynchronous communication
- Databases: PostgreSQL for each service
- Containerization: Docker

## Setup Instructions

1. Clone the repository
2. Install Docker and Docker Compose
3. Run `docker-compose up` to start all services

## API Documentation

### Product Service

- POST /api/products - Create product
- GET /api/products - List all products
- GET /api/products/{id} - Get product details
- PUT /api/products/{id} - Update product
- DELETE /api/products/{id} - Delete product

### Order Service

- POST /api/orders - Create order
- GET /api/orders - List all orders
- GET /api/orders/{id} - Get order details
- PUT /api/orders/{id} - Update order
- DELETE /api/orders/{id} - Cancel order

### Customer Service

- POST /api/customers - Create customer
- GET /api/customers - List all customers
- GET /api/customers/{id} - Get customer details
- PUT /api/customers/{id} - Update customer
- DELETE /api/customers/{id} - Delete customer

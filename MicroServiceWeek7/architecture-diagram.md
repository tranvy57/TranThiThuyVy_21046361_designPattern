# E-Commerce Microservices Architecture

```
┌─────────────────────────────────────────────────────────────────────────┐
│                           Client Application                             │
└───────────────────────────────┬─────────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                           API Gateway (8080)                             │
└───────────────┬───────────────┬───────────────┬─────────────────────────┘
                │               │               │
                ▼               ▼               ▼
┌───────────────┴───┐   ┌───────┴───────┐   ┌───┴───────────────┐
│  Product Service  │   │ Order Service │   │ Customer Service  │
│      (8081)       │   │    (8082)    │   │      (8083)       │
└─────────┬─────────┘   └───────┬───────┘   └─────────┬─────────┘
          │                     │                     │
          ▼                     ▼                     ▼
┌─────────┴─────────┐   ┌───────┴───────┐   ┌─────────┴─────────┐
│   Product DB      │   │   Order DB    │   │   Customer DB     │
└───────────────────┘   └───────────────┘   └───────────────────┘
          │                     │                     │
          │                     │                     │
          └──────────┬──────────┴──────────┬──────────┘
                     │                     │
                     ▼                     ▼
              ┌───────────────┐     ┌───────────────┐
              │   RabbitMQ    │     │   PostgreSQL  │
              └───────────────┘     └───────────────┘
```

## Service Communication Flow

1. **Client to API Gateway**:

   - All client requests go through the API Gateway
   - API Gateway routes requests to the appropriate service based on the URL path

2. **API Gateway to Services**:

   - `/api/products/**` → Product Service
   - `/api/orders/**` → Order Service
   - `/api/customers/**` → Customer Service

3. **Inter-Service Communication**:

   - Order Service → Product Service: Check product availability and update stock
   - Order Service → Customer Service: Verify customer information
   - All services → RabbitMQ: Asynchronous messaging for events

4. **Database Access**:
   - Each service has its own dedicated database
   - Product Service → Product DB
   - Order Service → Order DB
   - Customer Service → Customer DB

## Key Features

- **API Gateway**: Single entry point for all client requests
- **Service Isolation**: Each service has its own database and business logic
- **Asynchronous Communication**: RabbitMQ for event-driven communication
- **Authentication**: JWT-based authentication in the Customer Service
- **Containerization**: All services are containerized with Docker

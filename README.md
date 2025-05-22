# Employee-Department Microservice System

This is a microservices-based system built using Spring Boot and Spring Cloud components. It includes:

- Employee Service
- Department Service
- Spring Cloud Config Server
- Eureka Service Registry
- API Gateway

---



## 📦 Services Overview

### 1. **Employee Service**
- Manages employee-related data.
- Communicates with the Department Service to get department info.
- Port: `8080`
- Endpoint: `/employees`

### 2. **Department Service**
- Manages department-related data.
- Port: `8081`
- Endpoint: `/departments`

### 3. **Config Server**
- Centralized configuration management.
- Reads config from a Git repo.
- Port: `8082`

### 4. **Eureka Server (Service Registry)**
- Handles service discovery and registration.
- Port: `8761`

### 5. 🌐 API Gateway
- Entry point for all client requests.
- Routes requests to appropriate microservices.
- Secures endpoints with **Spring Security + JWT**.
- Port: `8083`
- Example routes:
  - `/employee/**` → Employee Service
  - `/department/**` → Department Service
  - `/auth/**` → Auth Service

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Spring Cloud (Eureka, Gateway, Config)
- Maven
- GitHub (for config repo)

---





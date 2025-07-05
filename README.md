# Spring Boot Microservices

![image](https://github.com/user-attachments/assets/12dab956-84d1-4e2a-b9c5-e14f90e9a994)

![image](https://github.com/user-attachments/assets/0aa42252-97ae-4418-b2f9-7200e3e46022)

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.1-green)
![GitHub last commit](https://img.shields.io/github/last-commit/Sarthak-Mishra-1628/Spring-Boot-Microservices)
![GitHub stars](https://img.shields.io/github/stars/Sarthak-Mishra-1628/Spring-Boot-Microservices?style=social)

## 📝 Description

A complete **Spring Boot Microservices-based backend system**, featuring distributed services with Eureka discovery, centralized configuration, secure communication with JWT and Auth0, and API Gateway routing. Ideal for real-world scalable applications.

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Cloud (Eureka, Config Server)
- Spring Security + JWT + Auth0
- REST API & Microservices
- Maven
- Postman for testing

---

## 📦 Services in this Project

| Service Name      | Port  | Description                           |
|-------------------|-------|---------------------------------------|
| `service-registry`| 8080  | Eureka server for service discovery   |
| `api-gateway`     | 8084  | API Gateway for routing + Auth check  |
| `config-server`   | 8085  | Centralized configuration server      |
| `user-service`    | 8081  | User management, Auth0/JWT integrated |
| `hotel-service`   | 8082  | CRUD APIs for hotel entities          |
| `rating-service`  | 8083  | Ratings & mapping with users/hotels   |

---

## 🚀 Features

- ✅ Microservices architecture
- 🔐 OAuth2/JWT authentication with Auth0
- 🔁 Eureka-based service discovery
- ⚙️ Externalized configuration via Config Server
- 🌐 API Gateway routing with security filters
- 🔄 Communication via Feign clients
- 🛡️ Rate limiting / Circuit breaker setup 
---

## 🔐 Authentication

- All secure endpoints are protected via **JWT** (issued by **Auth0**).
- Add this token to `Authorization: Bearer <your_token>` header.
- Gateway validates JWT and forwards request to internal services.

---

## 🧪 How to Test

Use Postman or any API client:
1. Get Auth0 token
2. Hit secure endpoints through `http://localhost:8084/...`
3. Microservices are internally routed via API Gateway

---



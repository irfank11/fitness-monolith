# Fitness Monolith API

A secure and scalable Fitness Tracking & Recommendation REST API built using **Spring Boot**, **Spring Security**, **JWT Authentication**, and **PostgreSQL**.

This project allows users to register, authenticate, track fitness activities, and receive personalized recommendations through secure API endpoints.

---

# Live Demo


### Swagger Documentation

https://fitness-monolith-5cme.onrender.com/swagger-ui/index.html

---

# 📸 Screenshots

## Swagger UI

> <img width="1280" height="722" alt="Screen Shot 2026-06-04 at 3 33 26 PM" src="https://github.com/user-attachments/assets/3f7790d8-6061-4735-b54f-fa8f88b59ed5" />
> <img width="1276" height="756" alt="Screen Shot 2026-06-04 at 3 34 18 PM" src="https://github.com/user-attachments/assets/327b364d-76b1-4943-85b2-e31e796cf659" />


```
```

---

# ✨ Features

* User Registration
* User Login & Authentication
* JWT-Based Authorization
* Password Encryption using BCrypt
* Activity Tracking
* Fitness Recommendations
* PostgreSQL Database Integration
* Global Exception Handling
* OpenAPI / Swagger Documentation
* Cloud Deployment on Render
* Environment Variable Configuration

---

# Tech Stack

## Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* JWT (JSON Web Tokens)

## Database

* PostgreSQL (Neon)

## Documentation

* Swagger / OpenAPI

## Deployment

* Render
  > <img width="1276" height="719" alt="Screen Shot 2026-06-04 at 4 13 12 PM" src="https://github.com/user-attachments/assets/1d7124c5-1ac8-4eed-b72b-890569e303c5" />


## Build Tool

* Maven

---

# Architecture Overview

```text
Client (Postman / Hoppscotch / Frontend)
                |
                v
        Spring Boot API
                |
    -----------------------
    |         |          |
Controllers Services Repositories
    |         |          |
    -----------------------
                |
                v
          PostgreSQL
             (Neon)
                |
                v
      Spring Security + JWT
```

---

# Request Flow

```text
User Request
      |
      v
JWT Authentication Filter
      |
      v
Controller
      |
      v
Service Layer
      |
      v
Repository Layer
      |
      v
PostgreSQL Database
      |
      v
Response
```

---

# 🔐 Authentication Flow

1. User registers an account.
2. User logs in using valid credentials.
3. Server validates credentials.
4. JWT token is generated and returned.
5. Client includes the JWT token in the Authorization header.
6. Protected endpoints verify the token before granting access.

### Authorization Header

```http
Authorization: Bearer <jwt_token>
```

---

# 📂 Project Structure

```text
src/main/java/com/project/fitness
│
├── Controller
├── Service
├── Repository
├── Security
├── Model
├── DTOs
├── Config
└── Exceptions
```

---

# API Endpoints

## Authentication

### Register User

```http
POST /api/auth/register
```

### Login User

```http
POST /api/auth/login
```

---

## Activities

### Create Activity

```http
POST /api/activities
```

### Get User Activities

```http
GET /api/activities
```

---

## Recommendations

### Generate Recommendation

```http
POST /api/recommendation/generate
```

### Get User Recommendations

```http
GET /api/recommendation/user/{user_id}
```

```http
GET /api/recommendation/activity/{activity_id}
```

> Endpoint names may vary slightly based on the latest implementation.

---

# Security

The application uses:

* JWT Authentication
* BCrypt Password Hashing
* Stateless Session Management
* Spring Security Filters
* Role-Based Authorization

### Public Endpoints

```text
POST /api/auth/register
POST /api/auth/login

GET  /swagger-ui/**
GET  /v3/api-docs/**
```

### Protected Endpoints

All remaining endpoints require a valid JWT token.

---

# API Documentation

Interactive API documentation is available through Swagger.

### Production

```text
https://fitness-monolith-5cme.onrender.com/swagger-ui/index.html
```

### Local Development

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Environment Variables

Create environment variables locally or on Render.

### Example

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://your-host/your-database?sslmode=require
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
```

---

# Running Locally

## Clone Repository

```bash
git clone https://github.com/irfank11/fitness-monolith.git
cd fitness-monolith
```

## Configure Environment Variables

Set:

```bash
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

## Run Application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

---

# Deployment

The application is deployed on:

* Render (Backend Hosting)
* Neon PostgreSQL (Database)

### Live URL

https://fitness-monolith-5cme.onrender.com

---

# Learning Outcomes

Through this project, I gained hands-on experience with:

* REST API Development
* Spring Boot Architecture
* Spring Security
* JWT Authentication & Authorization
* PostgreSQL Integration
* Environment Variables
* API Documentation with Swagger
* Cloud Deployment using Render
* Git & GitHub Workflow

---

# Future Improvements

### Version 2

* Refresh Tokens
* User Profile Management
* Password Reset
* Email Verification
* Docker Support
* Unit Testing
* Integration Testing

### Version 3

* AI-Powered Fitness Recommendations
* Workout Planning
* Nutrition Tracking
* Analytics Dashboard
* Frontend Integration (React)

---
If you found this project useful, consider giving it a star on GitHub!

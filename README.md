# Employee Management System

A RESTful Employee Management System built using **Java, Spring Boot, Spring Security, JWT Authentication, JPA/Hibernate, and PostgreSQL**.

The project provides secure authentication and role-based access to employee management APIs.

## 🚀 Features

* JWT-based authentication
* User login and token generation
* Spring Security integration
* Role-based authorization
* Employee CRUD operations
* DTO-based request and response handling
* Salary update restricted to authorized users
* Global exception handling
* Bean Validation
* PostgreSQL database integration
* JPA/Hibernate for database persistence
* Password encryption using BCrypt
* Secure API endpoints

## 🛠️ Tech Stack

| Technology      | Usage                          |
| --------------- | ------------------------------ |
| Java 21         | Programming language           |
| Spring Boot     | Backend framework              |
| Spring Security | Authentication & authorization |
| JWT             | Stateless authentication       |
| Spring Data JPA | Database access                |
| Hibernate       | ORM                            |
| PostgreSQL      | Database                       |
| Maven           | Build & dependency management  |
| JUnit           | Testing                        |

## 📁 Project Structure

```text
employee-management
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.employeemanagement
│   │   │       ├── config
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── exception
│   │   │       ├── repository
│   │   │       ├── security
│   │   │       └── service
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
├── .gitignore
└── README.md
```

## 🔐 Authentication Flow

The application uses JWT for stateless authentication.

```text
Client
   ↓
Login API
   ↓
Username & Password
   ↓
Spring Security
   ↓
Authentication
   ↓
JWT Token Generated
   ↓
Client stores Token
   ↓
Token sent with subsequent requests
   ↓
JwtAuthenticationFilter
   ↓
Token Validation
   ↓
Authorized API Access
```

## 🔑 Login

The client sends login credentials to the authentication endpoint.

Example:

```http
POST /auth/login
Content-Type: application/json
```

Request:

```json
{
  "username": "username",
  "password": "password"
}
```

A successful authentication returns a JWT token.

The token can then be sent with protected API requests:

```http
Authorization: Bearer <JWT_TOKEN>
```

## 👨‍💼 Employee APIs

The application provides APIs for managing employees.

Typical operations include:

```text
GET     /employees
GET     /employees/{id}
POST    /employees
PUT     /employees/{id}
DELETE  /employees/{id}
```

Protected endpoints require a valid JWT token.

## 🔒 Security

The application follows a stateless authentication approach using JWT.

Sensitive configuration such as the JWT secret should be supplied through environment variables rather than committed directly to the repository.

Example:

```text
JWT_SECRET=your-secret-key
```

Database credentials should also be configured locally and should not contain real production credentials in the repository.

## 🗄️ Database Configuration

The project uses PostgreSQL.

Example configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Create the PostgreSQL database before starting the application.

## ▶️ Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/employee-management.git
```

### 2. Open the project

Open the project in IntelliJ IDEA or another Java IDE.

### 3. Configure PostgreSQL

Create a PostgreSQL database and configure the database properties.

### 4. Configure JWT Secret

Set the JWT secret as an environment variable:

```text
JWT_SECRET=your-secret-key
```

### 5. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or run:

```text
EmployeeManagementApplication.java
```

from IntelliJ IDEA.

## 🧪 Testing

Run the test suite using:

```bash
mvn test
```

## 📌 Future Improvements

* Refresh token implementation
* Pagination and sorting
* Search and filtering
* API documentation using Swagger/OpenAPI
* Docker support
* Unit and integration test expansion
* CI/CD pipeline
* Production-ready externalized configuration


Java | Spring Boot | REST APIs | Spring Security | JWT | PostgreSQL

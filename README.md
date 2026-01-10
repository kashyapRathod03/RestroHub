# 🧭 RestroHub

**RestroHub** is a Spring Boot–based backend application that provides REST APIs for a **Restaurant QR Menu & Ordering System**.  
It enables restaurants to manage menus, categories, and food items for a **contactless QR-based dining experience**.

---

## 🚀 Features

- 🍽️ Food & Category Management
- 📱 QR-based Menu Support
- 🧩 Modular & Scalable Architecture
- 🗄️ PostgreSQL Integration
- 🔄 DTO Mapping using MapStruct
- 🛡️ Validation & Global Exception Handling
- 📘 Swagger / OpenAPI Documentation
- 🔐 Spring Security ready (JWT support planned)

---

## 🏗️ Tech Stack

| Layer        | Technology |
|-------------|-----------|
| Language     | Java 21 |
| Framework    | Spring Boot |
| ORM          | Spring Data JPA |
| Database     | PostgreSQL |
| Mapper       | MapStruct |
| Security     | Spring Security |
| Build Tool   | Gradle |
| API Docs     | SpringDoc OpenAPI |
| Validation   | Jakarta Validation |

---

## 📁 Project Structure
```
src/main/java/com/restrohub/qrmenu
├── category
├── food
├── order
├── common
├── config
└── utils

````

---

## ⚙️ Prerequisites

Make sure you have installed:

- Java 21
- Gradle
- PostgreSQL
- Git
- IDE (IntelliJ IDEA recommended)
- Lombok & MapStruct annotation processing enabled

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/rdodiya/RestroHub.git
cd RestroHub
````

---

### 2️⃣ Database Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/RestroHub_DB
spring.datasource.username=postgres
spring.datasource.password=admin123
```

---

### 3️⃣ Run the Application

```bash
./gradlew clean build
./gradlew bootRun
```

Application will start at:

```
http://localhost:8181/restroly
```

---

## 📘 API Base URL

```
/restroly/api/v1
```

### Example Endpoints

| Method | Endpoint      | Description     |
| ------ | ------------- | --------------- |
| GET    | `/foods`      | Get all foods   |
| GET    | `/foods/{id}` | Get food by ID  |
| POST   | `/foods`      | Create new food |
| PUT    | `/foods/{id}` | Update food     |
| DELETE | `/foods/{id}` | Delete food     |

Full URL Example:

```
http://localhost:8181/restroly/api/v1/foods/{id}
```

---

## 📘 Swagger API Documentation

Swagger UI is available at:

```
http://localhost:8181/restroly/swagger-ui.html
```

> If Swagger URLs look incorrect, ensure `server.servlet.context-path=/restroly`
> and OpenAPI `@OpenAPIDefinition(servers = "/restroly")` is configured.

---

## 🛡️ Security

* Spring Security is enabled
* JWT authentication support planned
* Role-based authorization can be added easily

---

## 🧪 Testing

Run tests using:

```bash
./gradlew test
```

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License**.

---

## 📌 About

**RestroHub** aims to simplify restaurant operations by enabling **contactless QR-based menu browsing and ordering**, making dining safer and more efficient.

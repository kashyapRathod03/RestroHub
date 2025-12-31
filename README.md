# 📌 RestroHub

**RestroHub** is a Spring Boot based Restaurant QR-Menu and Ordering System.
The project provides the backend APIs to manage menus, categories, foods, and QR code based ordering — enabling contactless restaurant experiences.

This repo includes:

* REST APIs for CRUD operations
* JPA entities for menu, category & food
* PostgreSQL database support
* QR code generation modules
* Spring Security stub for future enhancements

---

## 🧠 Features

✔ Modular backend architecture
✔ Category & Food management APIs
✔ Many-to-many relationships (Category ⇄ Food)
✔ QR menu support
✔ PostgreSQL integration
✔ Validation & exception handling
✔ Secure endpoints (Spring Security)

> *Further features may include waiter/room service apps, hotel food routing, order tracking, etc.* ([restrohub.com][1])

---

## 📁 Repo Structure

```
RestroHub/
├─ src/main/java
│   └─ com/restrohub/qrmenu
│       ├─ category
│       ├─ food
│       ├─ order
│       ├─ config
│       └─ utils
├─ src/main/resources
│   ├─ application.yml
│   └─ sql/
├─ build.gradle
├─ settings.gradle
├─ README.md
└─ LICENSE (MIT)
```

---

## 🚀 Getting Started

### Prerequisites

✔ Java 21
✔ Gradle
✔ PostgreSQL
✔ IDE (IntelliJ/Eclipse)
✔ Git

---

### Setup

1. **Clone the repo**

```bash
git clone https://github.com/rdodiya/RestroHub.git
cd RestroHub
```

2. **Configure Database**

Edit `application.yml` with your PostgreSQL credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/restrohub
    username: youruser
    password: yourpass
```

3. **Build & Run**

```bash
./gradlew clean build
./gradlew bootRun
```

API runs at:

```
http://localhost:8080
```

---

## 🧩 API Endpoints (Example)

CRUD endpoints might look like:

| Method | Route            | Description         |
| ------ | ---------------- | ------------------- |
| GET    | `/categories`    | List all categories |
| GET    | `/foods`         | List all foods      |
| POST   | `/menu`          | Create a new menu   |
| PUT    | `/food/{id}`     | Update food         |
| DELETE | `/category/{id}` | Delete category     |

*(Replace with actual routes from your controllers)*

---

## 📚 Entity Relationships

### Category

* `categoryId`, `name`, `description`, `isDelete`, `updatedDate`
* Mapped to foods via `@ManyToMany`

### Food

* Stores food details
* Linked back to categories

*(See entities for field names and relations)*

---

## 🔒 Security

Spring Security is included in dependencies and configured for future auth enhancements.

---

## ⚙️ Build Tool

This project uses **Gradle** with:

```gradle
org.springframework.boot 3.4.1
Java toolchain → 21
Lombok
MapStruct
PostgreSQL
```

Lombok annotations require **annotation processing enabled** in your IDE.

---

## 🖼️ Screenshots / Demos

*(You can add screenshots of API results, Postman collections, or QR scans here.)*

---

## 🛠️ Best Practices

✔ Implement DTO mappers
✔ Hide internal IDs with UUIDs
✔ Use JWT for secure endpoints
✔ Document APIs with Swagger

---

## 📝 Contributing

1. Fork it
2. Create feature branch
3. Commit changes
4. Raise pull request

We welcome improvements and fixes!

---

## 📃 License

This project is licensed under the **MIT License** — see `LICENSE` for details.

---

## ❓ About RestroHub

RestroHub is typically a QR-based restaurant ordering platform that allows guests to scan a code, browse menus, and place orders — ideal for hotels and restaurants aiming for contactless service. ([restrohub.com][1])

---


┌─────────────────────────────────────────────────────────────┐
│                    ORDER BUILDER PATTERN                    │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│   CreateOrderRequest                                        │
│         │                                                   │
│         ▼                                                   │
│   ┌─────────────────┐                                       │
│   │  OrderDirector  │  ◄── Orchestrates the building        │
│   └────────┬────────┘                                       │
│            │                                                │
│     ┌──────┴──────┐                                         │
│     ▼             ▼                                         │
│ ┌──────────┐ ┌──────────────┐                               │
│ │OrderItem │ │ OrderBuilder │                               │
│ │Builder   │ │              │                               │
│ └────┬─────┘ └──────┬───────┘                               │
│      │              │                                       │
│      ▼              ▼                                       │
│ ┌──────────┐ ┌──────────────┐                               │
│ │OrderItem │ │    Order     │  ◄── Final Product            │
│ │(Product) │ │  (Product)   │                               │
│ └──────────┘ └──────────────┘                               │
│                    │                                        │
│                    ▼                                        │
│              Save to DB                                     │
│                    │                                        │
│                    ▼                                        │
│           Notify Admin (WebSocket)                          │
│                                                             │
└─────────────────────────────────────────────────────────────┘
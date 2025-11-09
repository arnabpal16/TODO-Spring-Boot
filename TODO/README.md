# 📝 TODO App Backend (Spring Boot + MySQL)

A simple **Todo Web App backend** built with **Spring Boot**, **Spring Data JPA**, and **MySQL**.  
It provides REST APIs for creating, reading, updating, and deleting todos.

---

## 🚀 Features
- RESTful CRUD APIs for todos
- MySQL database integration using Spring Data JPA
- HikariCP connection pooling
- CORS enabled for frontend (React)
- Docker + Docker Compose support
- Easily deployable on any server or cloud platform

---

## 🧰 Tech Stack
| Layer | Technology |
|--------|-------------|
| Backend | Spring Boot 3.5.7 |
| Database | MySQL 8.0 |
| ORM | Hibernate (JPA) |
| Build Tool | Maven |
| Containerization | Docker & Docker Compose |
| Language | Java 17+ |

---


🧪 API Endpoints (Test in Postman)
Method	Endpoint	Description	Body (JSON)
GET	/api/todos	Get all todos	—
GET	/api/todos/{id}	Get todo by ID	—
POST	/api/todos	Create new todo	{ "title": "Buy milk", "description": "2 liters" }
PUT	/api/todos/{id}	Update todo	{ "completed": true }
DELETE	/api/todos/{id}	Delete todo	—

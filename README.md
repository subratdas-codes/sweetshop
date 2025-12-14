# 🍬 Sweet Shop Management System

## Overview
The **Sweet Shop Management System** is a full-stack application developed as part of the **AI Kata** assignment.  
The project demonstrates clean backend design, RESTful APIs, authentication, database integration, testing, and responsible usage of AI tools.

---

## Objective
To design and implement a secure and testable system that manages sweets inventory, supports user authentication, and enforces role-based access control.

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security (JWT Authentication)
- Spring Data JPA
- MySQL
- Maven

### Frontend
- React (Single Page Application)
- Axios  
*(Frontend UI is partially implemented and under active development)*

---

## Features Implemented

### Authentication & Security
- User Registration (`POST /api/auth/register`)
- User Login with JWT (`POST /api/auth/login`)
- JWT-based request authentication
- Role-based authorization (`ADMIN`, `USER`)
- Secured endpoints using Spring Security

### Sweet Management
- Add sweet (ADMIN only)
- Update sweet (ADMIN only)
- Delete sweet (ADMIN only)
- View all sweets
- Search sweets by name or category

---

## API Design
The application follows REST principles:
- Clear separation of Controller, Service, and Repository layers
- Stateless authentication using JWT
- Validation using Jakarta Bean Validation

---

## Database
- MySQL is used as the relational database
- Entities are mapped using JPA/Hibernate
- Automatic table creation via Hibernate configuration

---

## Testing
- Unit tests implemented using **JUnit 5**
- Service-level tests validate core business logic
- Development followed **Test Driven Development (TDD)** practices where applicable

---

## Setup Instructions

### Backend Setup
1. Clone the repository
2. Create a MySQL database
3. Configure `application.properties`
4. Run the application:
   ```bash
   mvn spring-boot:run


Frontend Setup

Navigate to the frontend directory

Install dependencies:

npm install


Run:

npm start


Frontend runs on:

http://localhost:3000

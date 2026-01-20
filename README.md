# Jackpot Service – Spring Boot Backend Demo

## Overview
This project is a small backend service inspired by iGaming jackpot systems.

It focuses on demonstrating **clean backend architecture**, **transactional consistency**, and **basic auditability**, rather than feature completeness.

The goal is to showcase how I structure code, handle data, and think about reliability and future evolution in backend systems.

---

## Tech Stack
- Java
- Spring Boot
- Spring Web (REST API)
- Spring Data JPA (Hibernate)
- H2 in-memory database
- Maven

---

## Architecture
The application follows a layered architecture:

- **Controller layer**
  - Handles HTTP requests and responses
  - Maps domain objects to DTOs

- **Service layer**
  - Contains business logic
  - Manages transactional operations

- **Repository layer**
  - Handles persistence using Spring Data JPA

This separation improves readability, testability, and long-term maintainability.

---

## Domain Model
- **Jackpot**
  - Represents the current jackpot state

- **JackpotWin**
  - Stores historical jackpot wins
  - Used for audit and traceability

---

## API Endpoints

### Get current jackpot
```http
GET /jackpot
```
### Contribute to jackpot
```http
POST /jackpot/contribute?amount=0.1
```
### Win jackpot
```http
POST /jackpot/win
```
### Get jackpot win history
```http
GET /jackpot/history
```

---

## Error Handling
The application uses centralized exception handling via `@ControllerAdvice` to return meaningful and consistent HTTP responses.

This avoids leaking internal errors to clients and keeps error handling logic separate from business logic.

Examples:
- Invalid contribution amount → `400 Bad Request`
- Attempting to win an empty jackpot → `409 Conflict`

---

## Database & Transactions
Persistence is handled using JPA and Hibernate, mapping domain entities to relational database tables.

Transactional boundaries are defined at the service layer to ensure data consistency when performing state-changing operations, such as:
- Recording a jackpot win
- Resetting the jackpot state

This guarantees that either **all related operations succeed**, or **none are applied**, which is critical in real-money systems.

---

## Testing
The API was manually tested using Postman to verify:
- Correct HTTP methods
- Expected responses
- Error scenarios and edge cases

---

## Possible Improvements
If extended further, the following improvements would be considered:
- Concurrency handling for high-load scenarios
- Authentication and authorization
- Pagination for history endpoints
- Database indexing and performance tuning
- Automated unit and integration tests

---

## Why this project
This project was created to demonstrate backend fundamentals that are critical in real-money systems:
**clear architecture**, **data consistency**, and **maintainable design**.




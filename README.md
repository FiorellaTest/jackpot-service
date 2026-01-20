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

### Contribute to jackpot
```http
POST /jackpot/contribute?amount=0.1

### Win jackpot
```http
POST /jackpot/win

### Get jackpot win history
```http
GET /jackpot/history




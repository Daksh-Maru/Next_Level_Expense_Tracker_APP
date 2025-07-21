# Next Level Expense Tracker App

A robust, production-ready backend system for tracking expenses, built with **Java**, **Spring Boot**, **Kafka**, and **Python**. This project enables secure user authentication, seamless user onboarding, and intelligent extraction of expense data from SMS messages using advanced AI models.

---

## Table of Contents

- [Project Overview](#project-overview)  
- [Architecture](#architecture)  
- [Features](#features)  
- [Service Details](#service-details)  
  - [AuthService](#authservice)  
  - [UserService](#userservice)  
  - [DsService](#dsservice)  
  - [ExpenseService](#expenseservice)  
- [Technologies Used](#technologies-used)  
- [Future Roadmap](#future-roadmap)
- [Repository](#repository)  

---

## Project Overview

**Next Level Expense Tracker App** is a microservices-based backend system that empowers users to automatically track and analyze their spending by parsing payment-related SMS messages. Built with a focus on modularity, scalability, and event-driven architecture, the system integrates easily with any web or mobile frontend.

---

## Architecture
------------
<pre><code>  
                         +------------+
                         |   Client   |
                         +------------+
                              |
                 +------------v-------------+
                 |       AuthService        |
                 +------------+-------------+
                              |
              (sends userData via Kafka)
                              v
                         +---------+
                         |  Kafka  |
                         +---------+
                              |
                              v
                       +-------------+
                       | UserService |
                       +-------------+

                              |
      (if authenticated)      v
                         +-------------+
                         | ExpenseService <-------------------+
                         +-------------+                      |
                              ^                               |
                              |                         (sends SMS expenses)
                         +------------+                      |
                         |  DsService  |---------------------+
                         +------------+


</code></pre>

- **AuthService**: Manages authentication, issues JWT tokens, and publishes user registration events to Kafka.  
- **UserService**: Consumes user registration events from Kafka and manages user data.  
- **DsService**: Parses SMS messages using MistralAI and sends extracted expense data to Kafka.  
- **ExpenseService**: Consumes parsed expenses from Kafka and provides access to user-specific expense data.

---

## Features

- 🔐 Secure user registration and authentication (JWT-based)  
- 🧩 Microservices architecture with clear separation of concerns  
- 🔁 Kafka-based asynchronous communication between services  
- 🤖 AI-powered SMS parsing for extracting payment details  
- 🚀 Easily extensible for future client-side development  

---

## Service Details

### AuthService
- **Language**: Java, Spring Boot  
- **Responsibilities**:
  - User registration and login  
  - JWT access and refresh token management  
  - Publishes user signup events to Kafka  
  - Secured with Spring Security  

### UserService
- **Language**: Java, Spring Boot  
- **Responsibilities**:
  - Consumes user registration events from Kafka  
  - Stores and manages user information in a database  

### DsService
- **Language**: Python  
- **Responsibilities**:
  - Parses SMS messages related to payments  
  - Uses MistralAI to extract payer, payee, amount, and date  
  - Publishes structured expense data to Kafka  

### ExpenseService
- **Language**: Java, Spring Boot  
- **Responsibilities**:
  - Consumes structured expense data from Kafka  
  - Stores and manages user-specific expense records  
  - Provides authenticated endpoints to retrieve and analyse expenses  

---

## Technologies Used

- **Java 21/22**, **Spring Boot**, **Spring Security**  
- **Python 3.8+**  
- **Apache Kafka**  
- **JWT (JSON Web Tokens)**  
- **MistralAI** for natural language understanding and SMS parsing  
- **Gradle** for Java project builds  
- **Docker** for containerization

---

## Future Roadmap

- [ ] Develop a client-side web/mobile application  
- [ ] Add support for more SMS/payment formats and banks  
- [ ] Implement real-time dashboards and analytics  
- [ ] Introduce alerting and budget tracking features  
- [ ] Add CI/CD pipelines with automated testing  
- [ ] Enhance service observability and security  

---

## Repository

[https://github.com/Daksh-Maru/Next_Level_Expense_Tracker_APP/tree/main](https://github.com/Daksh-Maru/Next_Level_Expense_Tracker_APP/tree/main)

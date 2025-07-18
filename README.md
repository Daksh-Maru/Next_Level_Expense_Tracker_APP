Next Level Expense Tracker App
=============================

A robust, production-ready backend system for tracking expenses, built with Java, Spring Boot, Kafka, and Python. This project provides secure user authentication, efficient user management, and intelligent extraction of payment information from SMS messages using advanced AI models.

---------------------------------------------------------------------
Table of Contents
-----------------
- Project Overview
- Architecture
- Features
- Sub-Projects
  - AuthService
  - UserService
  - DsService
- Getting Started
  - Prerequisites
  - Setup Instructions
- Configuration
- Technologies Used
- Contributing
- Future Roadmap
- License
- Acknowledgements

---------------------------------------------------------------------
Project Overview
----------------
Next Level Expense Tracker App is a microservices-based backend designed to help users track and analyse their expenses by parsing payment-related SMS messages. The system is modular, scalable, and ready for integration with web or mobile clients.

**Core Services:**
- AuthService: Handles user authentication and manages JWT tokens.
- UserService: Manages user data and listens to Kafka events for new user registrations.
- DsService: Parses SMS messages using AI (MistralAI) to extract structured payment information.

---------------------------------------------------------------------
Architecture
------------
<pre><code>
+------------+         +--------------+            +-------+
|  Client    | <-----> | AuthService  | <--------> | Kafka |
+------------+         +--------------+            +-------+
       ^                                               |
       |                                               |
       |                                               v
       |                +-----------+           +-------------+
       +--------------> | DsService | <-------> | UserService |
                        +-----------+           +-------------+
</code></pre>

- AuthService: Manages authentication, issues JWT tokens, and publishes user registration events to Kafka.
- UserService: Consumes user registration events from Kafka and manages user data.
- DsService: Consumes SMS messages, parses them using MistralAI, and extracts payment details.

---------------------------------------------------------------------
Features
--------
- Secure user registration and authentication (JWT-based)
- Microservices architecture with clear separation of concerns
- Kafka-based asynchronous communication between services
- AI-powered SMS parsing for extracting payment details
- Easily extensible for future client-side development

---------------------------------------------------------------------
Service-Details
------------

AuthService
-----------
- Language: Java, Spring Boot
- Responsibilities:
  - User registration and login
  - JWT access and refresh token management
  - Publishes user signup events to Kafka
  - Secured with Spring Security

UserService
-----------
- Language: Java, Spring Boot
- Responsibilities:
  - Consumes user registration events from Kafka
  - Stores and manages user information in a database

DsService
---------
- Language: Python
- Responsibilities:
  - Parses SMS messages related to payments
  - Uses MistralAI for extracting payer, payee, amount, and date
  - Designed for integration with future client applications

---------------------------------------------------------------------
Technologies Used
-----------------
- Java 17, Spring Boot, Spring Security
- JWT (JSON Web Tokens)
- Apache Kafka
- Python 3.8+
- MistralAI (for NLP-based SMS parsing)
- Gradle
- Docker (optional)

---------------------------------------------------------------------
Future Roadmap
--------------
- Develop Expense Service to track realtime expenses of user
- Develop and integrate a client-side application (web/mobile)
- Add support for more SMS/payment formats and banks
- Implement user dashboards and analytics
- Add automated testing and CI/CD pipelines
- Enhance security and monitoring

---------------------------------------------------------------------
Acknowledgements
----------------
- Spring Boot
- Apache Kafka
- MistralAI
- JWT.io

---------------------------------------------------------------------
Repository
----------
https://github.com/Daksh-Maru/Next_Level_Expense_Tracker_APP/tree/main




Next Level Expense Tracker App
=============================

A modern, microservices-based expense tracking backend built with Java, Spring Boot, Kafka, and Python. This project enables secure user authentication, robust user management, and intelligent extraction of payment information from SMS messages using advanced AI models.

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
- API Endpoints
- Technologies Used
- Contributing
- Future Roadmap
- License
- Acknowledgements

---------------------------------------------------------------------
Project Overview
----------------
Next Level Expense Tracker App is a backend system that helps users track and analyze their expenses by parsing payment-related SMS messages. The application is designed using a microservices architecture for scalability and maintainability. It currently consists of three main services:

- AuthService: Handles user authentication and JWT token management.
- UserService: Manages user data and listens to Kafka events for new user registrations.
- DsService: Parses SMS messages using MistralAI to extract structured payment information.

---------------------------------------------------------------------
Architecture
------------
+------------+         +--------------+         +-------------+
|  Client    | <-----> | AuthService  | <-----> |  UserService|
+------------+         +--------------+         +-------------+
       |                      |                        |
       |                      |                        |
       |                      v                        v
       |                +-----------+           +-------------+
       +--------------> |  Kafka    | <-------> |  DsService  |
                        +-----------+           +-------------+

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
Sub-Projects
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
Getting Started
---------------

Prerequisites
-------------
- Java 17 or higher
- Python 3.8 or higher
- Apache Kafka
- Maven
- Docker (optional, for containerization)
- Git

Setup Instructions
------------------
1. Clone the Repository
   git clone https://github.com/Daksh-Maru/Next_Level_Expense_Tracker_APP.git
   cd Next_Level_Expense_Tracker_APP

2. Start Kafka
   Follow the Kafka Quickstart Guide: https://kafka.apache.org/quickstart

3. Build and Run AuthService
   cd AuthService
   mvn clean install
   mvn spring-boot:run

4. Build and Run UserService
   cd ../UserService
   mvn clean install
   mvn spring-boot:run

5. Set up and Run DsService
   cd ../DsService
   pip install -r requirements.txt
   python app.py

6. Configure Environment Variables
   Set up environment variables or update configuration files for:
   - Database connections
   - Kafka brokers and topics
   - JWT secrets and expiration times

---------------------------------------------------------------------
API Endpoints
-------------

AuthService
-----------
/api/auth/register      [POST]   - Register a new user
/api/auth/login         [POST]   - Authenticate user and get tokens
/api/auth/refresh-token [POST]   - Refresh JWT token

UserService
-----------
/api/users/{id}         [GET]    - Get user details by ID
/api/users              [GET]    - List all users

DsService
---------
/api/ds/parse-sms       [POST]   - Parse SMS and extract payment info

*Note: Actual endpoints may vary based on implementation. Refer to each service's code for details.*

---------------------------------------------------------------------
Technologies Used
-----------------
- Java 17, Spring Boot, Spring Security
- JWT (JSON Web Tokens)
- Apache Kafka
- Python 3.8+
- MistralAI (for NLP-based SMS parsing)
- Maven
- Docker (optional)

---------------------------------------------------------------------
Contributing
------------
Contributions are welcome! To contribute:

1. Fork the repository
2. Create a new branch (git checkout -b feature/your-feature)
3. Commit your changes (git commit -am 'Add new feature')
4. Push to the branch (git push origin feature/your-feature)
5. Create a pull request

---------------------------------------------------------------------
Future Roadmap
--------------
- Develop and integrate a client-side application (web/mobile)
- Add support for more SMS/payment formats and banks
- Implement user dashboards and analytics
- Add automated testing and CI/CD pipelines
- Enhance security and monitoring

---------------------------------------------------------------------
License
-------
This project is licensed under the MIT License.

---------------------------------------------------------------------
Acknowledgements
----------------
- Spring Boot (https://spring.io/projects/spring-boot)
- Apache Kafka (https://kafka.apache.org/)
- MistralAI (https://mistral.ai/)
- JWT.io (https://jwt.io/)

---------------------------------------------------------------------
Repository
----------
https://github.com/Daksh-Maru/Next_Level_Expense_Tracker_APP/tree/main

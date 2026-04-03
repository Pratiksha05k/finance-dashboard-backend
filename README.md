# finance-dashboard-backend


##  Project Overview
This project is a backend system built using Spring Boot to manage financial data in a company environment.
It is not a personal finance application instead, it is designed to handle centralized company financial records where different users have different levels of access.
The system allows an admin to manage financial records such as income and expenses, while other roles like analysts and viewers can access the data based on their permissions.

## System Type
This is a **company-based finance system**, where:
* Data is managed centrally (not user-specific)
* Admin controls the system
* Other roles interact based on access level

## Role-Based Access Control

The system supports three roles:

* **ADMIN**
  * Full access to the system
  * Can create users and add financial records

* **ANALYST**
  * Can view records and dashboard data
  * Used for analyzing financial information

* **VIEWER**
  * Can only view financial records
  * No modification or dashboard access

## Features
* User management with roles
* JWT-based authentication
* Secure APIs with role-based access control
* Add and view financial records (income & expense)
* Dashboard APIs for:
  * Total Income
  * Total Expense
  * Balance calculation
    
## Tech Stack

* Java
* Spring Boot
* MySQL
* JWT (JSON Web Token)
* Maven

##  API Endpoints

### Authentication

* `POST /api/auth/login`

### User Management (Admin only)

* `POST /api/users`
* `GET /api/users`

### Financial Records

* `POST /api/records` (Admin only)
* `GET /api/records` (All roles)

### Dashboard (Admin & Analyst)

* `GET /api/dashboard/income`
* `GET /api/dashboard/expense`
* `GET /api/dashboard/balance`


## How to Run the Project

1. Clone the repository
2. Open in Spring Tool Suite / IntelliJ
3. Configure MySQL in `application.properties`
4. Run the Spring Boot application
5. Use Postman to test APIs


## Key Learning

This project helped me understand how backend systems work in real-world scenarios, 
especially in terms of authentication, authorization, and handling role-based access.


## Note

This project focuses only on backend development and API design. It can be extended further by integrating a frontend.
